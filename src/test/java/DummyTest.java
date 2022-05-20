import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    private static final int AXE_ATTACK = 1;
    private static final int AXE_DURABILITY = 10;

    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;
    private static final int DEAD_DUMMY_HP = 0;

    private Dummy dummy;
    private Dummy deadDummy;
    private Axe axe;

    @Before
    public void setUp() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
        this.deadDummy = new Dummy(DEAD_DUMMY_HP, DUMMY_XP);
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
    }

    @Test
    public void testDummyLosesHealthWhenAttacked() {
        //Act
        dummy.takeAttack(axe.getAttackPoints());
        //Assert
        Assert.assertEquals(9, dummy.getHealth());
    }

    //Assert
    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsExceptionWhenAttacked() {
        //Act
        deadDummy.takeAttack(axe.getAttackPoints());
    }

    @Test
    public void testDeadDummyGivesXp() {
        //Act
        int xpGiven = deadDummy.giveExperience();
        Assert.assertEquals(DUMMY_XP, xpGiven);
    }

    @Test(expected = IllegalStateException.class)
    public void testLivingDummyThrowsExceptionWhenGivingXp() {
        //Act
        dummy.giveExperience();
    }
}
