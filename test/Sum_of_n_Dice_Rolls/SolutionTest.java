package Sum_of_n_Dice_Rolls;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution;

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void testAdd() {
        int[] v1 = new int[]{1, 1, 1, 2, 2, 2, 3};
        int[] v2 = new int[]{0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 0};
        int[] expectV2 = new int[]{0, 1, 2, 4, 5, 6, 8, 7, 6, 6, 2, 1, 0};
        solution.add(v1, v2, 3);
        assertArrayEquals(String.format("The v2 should be %s", Arrays.toString(expectV2)), v2, expectV2);
    }

    @Test
    public void testDicesProbability() {
        double[] one = solution.dicesProbability(1);
        double[] oneExpect = new double[]{0.16667,0.16667,0.16667,0.16667,0.16667,0.16667};
        assertArrayEquals(String.format("The probability of 1 dices is %s", Arrays.toString(oneExpect)), one, oneExpect, 0.00001);

        double[] twelve = solution.dicesProbability(12);
        double[] twelveExpect = new double[]{0.00000,0.00000,0.00000,0.00000,0.00000,0.00000,0.00001,0.00001,0.00003,0.00008,0.00015,0.00030,0.00055,0.00097,0.00163,0.00263,0.00409,0.00611,0.00882,0.01230,0.01661,0.02174,0.02759,0.03400,0.04069,0.04733,0.05353,0.05889,0.06303,0.06564,0.06654,0.06564,0.06303,0.05889,0.05353,0.04733,0.04069,0.03400,0.02759,0.02174,0.01661,0.01230,0.00882,0.00611,0.00409,0.00263,0.00163,0.00097,0.00055,0.00030,0.00015,0.00008,0.00003,0.00001,0.00001,0.00000,0.00000,0.00000,0.00000,0.00000,0.00000};

        assertArrayEquals(String.format("The probability of 12 dices is %s", Arrays.toString(twelveExpect)), twelve, twelveExpect, 0.00001);
    }
}
