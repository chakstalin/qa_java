package praktikum.tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import java.util.List;
import static org.junit.Assert.*;
import com.example.*;
import org.mockito.MockitoAnnotations;

public class LionAlexTest {

    private LionAlex alex;

    @Mock
    private Feline feline;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        alex = new LionAlex(feline);
    }

    @Test
    public void testGetFriends() throws Exception {

        List<String> friends = alex.getFriends();
        assertEquals(List.of("Марти", "Глория", "Мелман"), friends);
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {

        assertEquals("Неверное место, где Алекс живет","Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testGetKittens() throws Exception {

        assertEquals("У Алекса нет котят", 0, alex.getKittens());
    }
}
