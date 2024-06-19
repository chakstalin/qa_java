package praktikum.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import com.example.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    private Cat cat;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cat = new Cat(feline);
    }

    @Test
    public void testGetSoundReturnsMeow() {

        String expectedSound = "Мяу";
        assertEquals("Кошка должна мяукать", expectedSound, cat.getSound());
    }

    /*
    проверка подтверждает, что метод GetFood класса Cat правильно вызывает метод GetFood класса Feline с нужным аргументом
    и возвращает ожидаемый результат
    по сути проверяется взаимодействие между методами
     */
    @Test
    public void testCatGetFoodMethodCallsFelineEatMeatMethod() throws Exception {

        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(food);
        assertEquals("Возвращаемые значения методов отличаются", food, cat.getFood());
    }
}

