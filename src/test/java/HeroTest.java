import org.junit.Test;
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class HeroTest {

    @After
    public void tearDown() {
        Hero.clearAll();
    }
    @Test
    public void Hero_instatiatesCorrectly_true() {
        Squad testSquad = new Squad("Gang", 2,"Protect");
        Hero testHero = new Hero("name", 12,"speed","weak",testSquad.getId());
        assertTrue(testHero instanceof Hero);
    }
    @Test
    public void getName_returnsString_mario() {
        Squad testSquad = new Squad("Gang", 2,"Protect");
        Hero testHero = new Hero("Maria", 12, "telaport","dudes",testSquad.getId());
        assertEquals("Maria", testHero.getName());
    }
    @Test
    public void getAge_returnsInteger_12() {
        Squad testSquad = new Squad("Gang", 2,"Protect");
        Hero testHero = new Hero("Maria", 22, "telaport","dudes",testSquad.getId());
        assertEquals(22,testHero.getAge());
    }
    @Test
    public void getPower_returnsString_cooking() {
        Squad testSquad = new Squad("Gang", 2,"Protect");
        Hero testHero = new Hero("Maria", 22, "telaport","dudes",testSquad.getId());
        assertEquals("telaport",testHero.getPower());
    }
    @Test
    public void getWeakness_returnsString_eating() {
        Squad testSquad = new Squad("Gang", 2,"Protect");
        Hero testHero = new Hero("Maria", 22, "telaport","dudes",testSquad.getId());;
        assertEquals("dudes", testHero.getWeakness());
    }
    @Test
    public void getId_assignsUniqueId_int() {
        Squad testSquad = new Squad("Gang", 2,"Protect");
        Hero testHero = new Hero("Maria", 22, "telaport","dudes",testSquad.getId());
        assertEquals(1,testHero.getId());
    }
    @Test
    public void getSquadId_assignsEachHeroItsSquadId_int() {
        Squad testSquad = new Squad("Gang", 2,"Protect");
        Hero testHero = new Hero("Maria", 22, "telaport","dudes",testSquad.getId());
        testSquad.addHero(testHero);
        assertEquals(testSquad.getId(),testHero.getSquadId());
    }
    @Test
    public void instances_containsHeroObjectsCreated_true() {
        Squad testSquad = new Squad("Gang", 2,"Protect");
        Hero testHero = new Hero("Maria", 22, "telaport","dudes",testSquad.getId());
        Hero anotherTestHero = new Hero("Marie",23,"drinking","men",testSquad.getId());
        assertTrue(Hero.getHeroes().contains(testHero));
        assertTrue(Hero.getHeroes().contains(anotherTestHero));
    }
    @Test
    public void getHeroes_returnsList_List() {
        Squad testSquad = new Squad("Gang", 2,"Protect");
        Hero testHero = new Hero("Maria", 22, "telaport","dudes",testSquad.getId());
        List<Hero> expectedOutput = new ArrayList<Hero>();
        expectedOutput.add(testHero);
        assertEquals(expectedOutput.get(0), Hero.getHeroes().get(0));
    }
    @Test
    public void find_ReturnsAnInstanceOfHeroes_Hero() {
        Squad testSquad = new Squad("Gang", 2,"Protect");
        Hero testHero = new Hero("men",12,"eating","food",testSquad.getId());
        assertEquals(testHero,Hero.findHero(1));
    }
    @Test
    public void find_returnsCorrectHeroWhenMoreThanOneExists_Hero() {
        Squad testSquad = new Squad("Gang", 2,"Protect");
        Hero testHero = new Hero("Maria", 22, "telaport","dudes",testSquad.getId());
        Hero another = new Hero("Marie", 23,"superstrength","men",testSquad.getId());
        assertEquals(another,Hero.findHero(2));
    }
}