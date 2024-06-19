package praktikum.tests;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import com.example.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class AnimalTest {

    private Animal animal;

    @Before
    public void setUp(){

    animal = new Animal();
    }

    /*
    Эти проверки с учётом того, что списки еды вряд ли сократяться, но могут расшириться
    Напр. насекомые для хищника и т.п.
     */
    @Test
    public void testGetFoodHerbivoreReturnsPlants() throws Exception {

        List<String> food = animal.getFood("Травоядное");
        assertNotNull("Список еды не должен быть пустым", food);
        assertTrue("Список еды должен содержать траву", food.contains("Трава"));
        assertTrue("Список еды должен содержать различные растения", food.contains("Различные растения"));
    }

    @Test
    public void testGetFoodCarnivoreReturnsMeat() throws Exception {

        List<String> food = animal.getFood("Хищник");
        assertNotNull("Список еды не должен быть пустым", food);
        assertTrue("Список еды должен содержать животных", food.contains("Животные"));
        assertTrue("Список еды должен содержать птицу", food.contains("Птицы"));
        assertTrue("Список еды должен содержать рыбу", food.contains("Рыба"));
    }

    @Test
    public void testGetFoodUnexpectedMealThrowsException() throws Exception {

        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Самоед");
        });

        assertEquals("Неверное сообщение в исключении","Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    public void testGetFamilyReturnsAnimalFamilies() {

        String family = animal.getFamily();
        assertEquals("Неверное описание семейств животных",
                "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", family);
    }
}
