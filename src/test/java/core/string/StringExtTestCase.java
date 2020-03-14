package core.string;

import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringExtTestCase {

    @Test
    public void compare2strs() {
        String s0 = "Hello world!";

        String s1 = "Hello world!";
        Optional<StringComparer.Diff> result1 = StringComparer.compare2strs(s0, s1);
        assertFalse(result1.isPresent());
        try {
            StringComparer.Diff r1 = result1.get();
        } catch (NoSuchElementException e) {
            assertEquals(NoSuchElementException.class, e.getClass());
            assertEquals("No value present", e.getMessage());
        }

        String s2 = "Hello world";
        Optional<StringComparer.Diff> result2 = StringComparer.compare2strs(s0, s2);
        assertTrue(result2.isPresent());
        String exp2 = String.format("%d @ [%d] -> [%s]%n", 1, 11, "!") + String.format("%d @ [%d] -> [%s]%n", 2, 11, "");
        assertEquals(exp2, result2.get().toString());
        System.out.printf("%s%n", result2.get());

        String s3 = "Hello world! ";
        Optional<StringComparer.Diff> result3 = StringComparer.compare2strs(s0, s3);
        assertTrue(result3.isPresent());
        String exp3 = String.format("%d @ [%d] -> [%s]%n", 1, 13, "") + String.format("%d @ [%d] -> [%s]%n", 2, 13, " ");
        assertEquals(exp3, result3.get().toString());
        System.out.printf("%s%n", result3.get());

        String s4 = "Helloworld!";
        Optional<StringComparer.Diff> result4 = StringComparer.compare2strs(s0, s4);
        assertTrue(result4.isPresent());
        String exp4 = String.format("%d @ [%d] -> [%s]%n", 1, 5, " world!") + String.format("%d @ [%d] -> [%s]%n", 2, 5, "world!");
        assertEquals(exp4, result4.get().toString());
        System.out.printf("%s%n", result4.get());

        String s5 = "Hello  world!";
        Optional<StringComparer.Diff> result5 = StringComparer.compare2strs(s0, s5);
        assertTrue(result5.isPresent());
        String exp5 = String.format("%d @ [%d] -> [%s]%n", 1, 6, "world!") + String.format("%d @ [%d] -> [%s]%n", 2, 6, " world!");
        assertEquals(exp5, result5.get().toString());
        System.out.printf("%s%n", result5.get());
    }
}