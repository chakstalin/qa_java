package praktikum.tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
import com.example.*;

public class LionTest {

    private Lion lionMale;

    @Mock
    private Feline feline;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        lionMale = new Lion("Самец", feline);
    }

    /*
    проверка подтверждает, что метод GetKittens класса Lion правильно вызывает метод GetKittens класса Feline с нужным аргументом
    и возвращает ожидаемый результат
    по сути проверяется взаимодействие между методами
     */
    @Test
    public void testLionGetKittensMethodCallsFelineGetKittensMethod() {

        int kittensCount = 3;
        Mockito.when(feline.getKittens()).thenReturn(kittensCount);
        assertEquals("Возвращаемые значения методов отличаются", kittensCount, lionMale.getKittens());
    }

    /*
    аналогично для GetFood класса Lion и GetFood класса Feline
     */
    @Test
    public void testLionGetFoodMethodCallsFelineGetFoodMethod() throws Exception {

        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(food);
        assertEquals("Возвращаемые значения методов отличаются",food, lionMale.getFood());
    }

}

