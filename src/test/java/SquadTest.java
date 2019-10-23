import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;


public class SquadTest {
    @Before
    public void setUp() {

    }
    @After
    public void tearDown() {
        Squad.clearSquads();
    }
    @Test
    public void SquadInstatiatesCorrectly_true() {
        Squad damn = new Squad("Scans",12,"scan");
        assertTrue(damn instanceof Squad);
    }
    @Test
    public void getName_returnsNameOfSquad_Shooters() {
        Squad damn = new Squad("Avengers",1,"Assemble");
        assertEquals("Avengers", damn.getName());
    }
    @Test
    public void getSize_returnsInteger_1() {
        Squad damn = new Squad("Avengers",1,"assemble");
        assertEquals(1,damn.getSize());
    }
    @Test
    public void getCause_returnsString_shoot() {
        Squad damn = new Squad("Avengers",1,"assemble");
        assertEquals("assemble",damn.getCause());
    }
    @Test
    public void getId_assignsUniqueId_1() {
        Squad damn = new Squad("Avengers",1,"assemble");
        assertEquals(1,damn.getId());
    }
    @Test
    public void getSquads_returnsAllSquadsCreated_ArrayList() {
        Squad damn = new Squad("Avengers",1,"assemble");
        assertTrue(Squad.getSquads().contains(damn));
    }
    @Test
    public void getHeroes_returnsListOfHeroes_List() {
        Squad damn = new Squad("Avengers",1,"assemble");
        Hero muchui = new Hero("Alice",1,"telaport","food",damn.getId());
        damn.addHero(muchui);
        List<Hero> expected = new ArrayList<Hero>();
        expected.add(muchui);
        assertEquals(expected.get(0),damn.getHeroes().get(0));
    }
    @Test
    public void addHero_AddsHeroes_true() {
        Squad damn = new Squad("Avengers",1,"assemble");
        Hero muchui = new Hero("", 12, "web", "gaming",damn.getId());
        damn.addHero(muchui);
        assertTrue(damn.getHeroes().contains(muchui));
    }
    @Test
    public void addHero_doesNotAddHeroesOnceSquadSizeIsExceeded_false() {
        Squad damn = new Squad("Avengerss",1,"assemble");
        Hero Captain = new Hero("Captain", 34, "superstrong", "Girls",damn.getId());
        Hero Henry = new Hero("Henry",12,"superspeed","Ponytails",damn.getId());
        damn.addHero(Captain);
        damn.addHero(Henry);
        assertTrue(damn.getHeroes().contains(Captain));
        assertFalse(damn.getHeroes().contains(Henry));
    }
    @Test
    public void removeHero_removesSingleInstanceOfHero_false() {
        Squad damn = new Squad("Avengers",1,"assemble");
        Hero Captain = new Hero("Captain", 34, "superstrong", "Girls",damn.getId());
        Hero Henry = new Hero("Henry",12,"superspeed","Ponytails",damn.getId());
        damn.addHero(muchui);
        damn.addHero(victor);
        damn.removeHero(victor);
        assertFalse(damn.getHeroes().contains(victor));
    }
    @Test
    public void removeHeroes_removesSingleInstanceOfHero_false() {
        Squad damn = new Squad("Avengers",2,"assemble");
        Hero Captain = new Hero("Captain", 34, "superstrong", "Girls",damn.getId());
        Hero Henry = new Hero("Henry",12,"superspeed","Ponytails",damn.getId());
        damn.addHero(muchui);
        damn.addHero(victor);
        damn.removeHeroes();
        assertFalse(damn.getHeroes().contains(victor));
        assertFalse(damn.getHeroes().contains(muchui));
    }
    @Test
    public void find_ReturnsAnInstanceOfSquad_Squad() {
        Squad damn = new Squad("Avengerss",1,"assemble");
        assertEquals(damn,Squad.find(1));
    }
    @Test
    public void find_returnsCorrectHeroWhenMoreThanOneExists_Hero() {
        Squad damn = new Squad("Avengers",1,"assemble");
        Squad another = new Squad("Cliff",21,"cake");
        assertEquals(another,Squad.find(2));
    }
}