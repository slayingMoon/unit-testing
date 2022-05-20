import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    @Test
    public void testAxeLosesDurabilityAfterAttack() {
        //Arrange
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(10, 10);
        //Act
        axe.attack(dummy);
        //Assert
        //expectations vs reality
        Assert.assertEquals(9, axe.getDurabilityPoints());
    }

    //Assert
    @Test(expected = IllegalStateException.class)
    public void testAxeAttackThrowsExceptionIfAxeIsBroken() {
        //Arrange
        Axe brokenAxe = new Axe(10, 1);
        Dummy dummy = new Dummy(10, 10);
        //Act
        brokenAxe.attack(dummy);
        //should break
        brokenAxe.attack(dummy);
    }
}