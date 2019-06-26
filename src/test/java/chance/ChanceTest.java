package chance;

import com.lyf.chance.Chance;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChanceTest {
    private double probabilityOfChanceA;
    private double probabilityOfChanceB;
    private Chance chanceA;
    private Chance chanceB;

    @Before
    public void setUp() {
        probabilityOfChanceA = 0.32d;
        probabilityOfChanceB = 0.55d;
        chanceA = new Chance(probabilityOfChanceA);
        chanceB = new Chance(probabilityOfChanceB);
    }

    @Test
    public void should_get_correct_probability_when_applying_not_method() {
        //when
        Chance result = chanceA.not();
        //then
        assertEquals(result.getProbability(), 1 - probabilityOfChanceA, 0.0);
    }

    @Test
    public void should_get_correct_probability_when_applying_and_method() {
        //when
        Chance result = chanceA.and(chanceB);
        //then
        assertEquals(result.getProbability(), probabilityOfChanceA * probabilityOfChanceB, 0.0);
    }

    @Test
    public void should_get_correct_probability_when_applying_or_method() {
        //when
        Chance result = chanceA.or(chanceB);
        //then
        assertEquals(result.getProbability(), probabilityOfChanceA + probabilityOfChanceB -
                (probabilityOfChanceA * probabilityOfChanceB), 0.0);
    }
}
