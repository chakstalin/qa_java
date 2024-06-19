package praktikum.tests;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import com.example.*;

public class FelineTest {

    private Feline feline;
    @Before
    public void setUp() {

        feline = new Feline();
    }

    @Test
    public void testEatMeatReturnsFoodList() throws Exception {

        List<String> food = feline.eatMeat();
        assertNotNull("Список еды не должен быть пустым", food);
        assertTrue("Список еды должен содержать животных", food.contains("Животные"));
        assertTrue("Список еды должен содержать птицу", food.contains("Птицы"));
        assertTrue("Список еды должен содержать рыбу", food.contains("Рыба"));
    }

    @Test
    public void testGetFamilyReturnsFelineFamily() {

        assertEquals("Должно вернуться Кошачьи","Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensWithoutArgumentReturnsOne() {

        assertEquals("Без аргументов должен вернуться один котенок",1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithArgumentReturnsKittensCount() {

        int kittensCount = 3;
        assertEquals("Должно вернуться переданное в аргументе количество котят", kittensCount, feline.getKittens(kittensCount));
    }
}
