package Add_Bold_Tag_in_String;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SolutionTest {
    Add_Bold_Tag_in_String.Solution solution;
    Add_Bold_Tag_in_String.SolutionStringBuilder solutionStringBuilder;

    @Before
    public void setUp() {
        solution = new Solution();
        solutionStringBuilder = new SolutionStringBuilder();
    }

    @Test
    public void testAddBoldTag() {
        String s = "abcxyz123";
        String[] words = new String[]{"abc", "123"};
        String taggedString = solution.addBoldTag(s, words);
        assertEquals("The string should be <b>abc</b>xyz<b>123</b>", "<b>abc</b>xyz<b>123</b>", taggedString);
    }

    @Test
    public void testAddBoldTagWithSB() {
        String s = "abcxyz123";
        String[] words = new String[]{"abc", "123"};
        String taggedString = solutionStringBuilder.addBoldTag(s, words);
        assertEquals("The string should be <b>abc</b>xyz<b>123</b>", "<b>abc</b>xyz<b>123</b>", taggedString);
    }
}
