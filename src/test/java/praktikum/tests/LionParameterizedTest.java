package praktikum.tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Mock
    private Feline feline;

    private Lion lion;

    private final String sex;
    private final boolean expected;
    private final boolean shouldThrowException;

    public LionParameterizedTest(String sex, boolean expected, boolean shouldThrowException){
        this.sex = sex;
        this.expected = expected;
        this.shouldThrowException = shouldThrowException;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"Самец", true, false},
                {"Самка", false, false},
                {"Небинарный лев", false, true}
        };
    }

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoesHaveMane() throws Exception {

        if (shouldThrowException) {

            Exception exception = assertThrows(Exception.class, () -> {
                lion = new Lion(sex, feline);
            });

            assertEquals("Неверное сообщение в исключении","Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        } else {
            lion = new Lion(sex, feline);
            assertEquals("Неверное значение для наличия гривы", expected , lion.doesHaveMane());
        }
    }
}
