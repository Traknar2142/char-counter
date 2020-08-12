package ua.com.foxminded.task5.charcounter;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.lang.reflect.Field;
import java.time.Duration;
import java.util.Map;

import org.junit.jupiter.api.Test;

class CharCounterTest {
    CharCounter counter = new CharCounter();
    Class counterReflect = counter.getClass();
    
    @Test
    void countLetters_TestShouldPass_WhenKeyAndValueInCacheAndReflectCacheIsTheSame() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
        counter.printUniqueCharacters("Cache check");
        Field cache = counterReflect.getDeclaredField("cache");
        cache.setAccessible(true);
        Map<String, String> cacheReflect = (Map<String, String>) cache.get(counter);
        cacheReflect.containsKey("Cache check");
        assertTrue(cacheReflect.containsKey("Cache check") && cacheReflect.containsValue("Cache check\n" +
                                                                                         "\"C\" - 1\n" + 
                                                                                         "\"a\" - 1\n" + 
                                                                                         "\"c\" - 3\n" + 
                                                                                         "\"h\" - 2\n" + 
                                                                                         "\"e\" - 2\n" + 
                                                                                         "\" \" - 1\n" + 
                                                                                         "\"k\" - 1\n"));
    }
    
    @Test
    void countLetters_TestShouldPass_WhenTimeOfSecondMethodCallIsLessThanFirstCall() {
        long startTime = System.currentTimeMillis();
        String inputString = "The end is never the end is never the end is never the end is never the end is never the end is never "
                + "the end is never the end is never the end is never the end is never the end is never the end is never the end is never "
                + "the end is never the end is never the end is never the end is never the end is never the end is never the end is never "
                + "the end is never the end is never the end is never the end is never the end is never the end is never the end is never "
                + "the end is never the end is never the end is never the end is never the end is never the end is never the end is never "
                + "the end is never the end is never the end is never the end is never the end is never the end is never the end is never "
                + "the end is never the end is never the end is never the end is never the end is never the end is never the end is never "
                + "the end is never the end is never the end is never the end is never the end is never the end is never the end is never "
                + "the end is never the end is never the end is never the end is never the end is never the end is never the end is never "
                + "the end is never the end is never the end is never the end is never the end is never the end is never the end is never "
                + "the end is never the end is never the end is never the end is never the end is never the end is never the end is never "
                + "the end is never the end is never the end is never the end is never the end is never the end is never the end is never "
                + "the end is never the end is never the end is never the end is never the end is never the end is never the end is never "
                + "the end is never the end is never the end is never the end is never the end is never the end is never the end is never "
                + "the end is never the end is never the end is never the end is never the end is never the end is never the end is never ";
        counter.printUniqueCharacters(inputString);
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        assertTimeout(Duration.ofMillis(duration), () -> counter.printUniqueCharacters(inputString));
    }

    @Test
    void countLetters_ShouldReturnNothing_WhenInputIsNothing() {
        String input = "";
        String expected = "";
        assertEquals(expected, counter.printUniqueCharacters(input));
    }

    @Test
    void countLetters_ShouldReturnOneSpace_WhenInputIsOneSpace() {
        String input = " ";
        String expected = " \n" + 
                          "\" \" - 1";
        assertEquals(expected, counter.printUniqueCharacters(input));
    }
    
    @Test
    void countLetters_ShouldReturnOneSpace_WhenInputIsTwoSpaces() {
        String input = "  ";
        String expected = "  \n" + 
                          "\" \" - 2";
        assertEquals(expected, counter.printUniqueCharacters(input));
    }
    
    @Test
    void countLetters_ShouldReturnOneSlash_WhenInputIsOneSlash() {
        String input = "/";
        String expected = "/\n" + 
                          "\"/\" - 1";
        assertEquals(expected, counter.printUniqueCharacters(input));
    }
    
    @Test
    void countLetters_ShouldReturnOneSlash_WhenInputIsTwoSlash() {
        String input = "//";
        String expected = "//\n" + 
                          "\"/\" - 2";
        assertEquals(expected, counter.printUniqueCharacters(input));
    }
    
    @Test
    void countLetters_ShouldReturnOneSlashAndTwoAInDifferentRegisters_WhenInputIsTwoSlashAndAlettersInDifferentRegisters() {
        String input = "//AaaAA";
        String expected = "//AaaAA\n" + 
                          "\"/\" - 2\n" + 
                          "\"A\" - 3\n" + 
                          "\"a\" - 2";
        assertEquals(expected, counter.printUniqueCharacters(input));
    }       
    
    @Test
    void countLetters_ShouldReturnOneQuestionMarkAndTilde_WhenInputIsTwoTweoQuestionsMarkAndTwoTildes() {
        String input = "??~~";
        String expected = "??~~\n" + 
                          "\"?\" - 2\n" + 
                          "\"~\" - 2";
        assertEquals(expected, counter.printUniqueCharacters(input));
    }
    
    @Test
    void countLetters_ShouldReturnColumnWithOne_WhenInputIsOne() {
        String input = "1";
        String expected = "1\n" + 
                          "\"1\" - 1";
        assertEquals(expected, counter.printUniqueCharacters(input));
    }
    
    @Test
    void countLetters_ShouldReturnColumnWithOneAndSpace_WhenInputIsSixUnitsSeparatedBySpace() {
        String input = "111 111";
        String expected = "111 111\n" + 
                          "\"1\" - 6\n" +
                          "\" \" - 1";
        assertEquals(expected, counter.printUniqueCharacters(input));
    }
    
    @Test
    void countLetters_ShouldReturnColumnWithOne_WhenInputIsThreeUnits() {
        String input = "111";
        String expected = "111\n" + 
                          "\"1\" - 3";
        assertEquals(expected, counter.printUniqueCharacters(input));
    }
    
    @Test
    void countLetters_ShouldReturnNumbersFromOneToNine_WhenInputIsNumbersFromOneToNine() {
        String input = "123456789";
        String expected = "123456789\n" + 
                          "\"1\" - 1\n" + 
                          "\"2\" - 1\n" + 
                          "\"3\" - 1\n" + 
                          "\"4\" - 1\n" + 
                          "\"5\" - 1\n" + 
                          "\"6\" - 1\n" + 
                          "\"7\" - 1\n" + 
                          "\"8\" - 1\n" +
                          "\"9\" - 1"; 
        assertEquals(expected, counter.printUniqueCharacters(input));
    }
    
    @Test
    void countLetters_ShouldReturnColumnWithSymbols_WhenInputIsStringOfSymbols() {
        String input = "!!@@##$$%%^^&&**(())__++";
        String expected = "!!@@##$$%%^^&&**(())__++\n" + 
                          "\"!\" - 2\n" +
                          "\"@\" - 2\n" +
                          "\"#\" - 2\n" +
                          "\"$\" - 2\n" +
                          "\"%\" - 2\n" +
                          "\"^\" - 2\n" +
                          "\"&\" - 2\n" +
                          "\"*\" - 2\n" +
                          "\"(\" - 2\n" +
                          "\")\" - 2\n" +
                          "\"_\" - 2\n" +
                          "\"+\" - 2";
        assertEquals(expected, counter.printUniqueCharacters(input));
    }

    @Test
    void countLetters_ShouldReturnColumnWithLetterCount_WhenInputIsHelloworld() {
        String input = "Hello world!";
        String expected = "Hello world!\n" + 
                          "\"H\" - 1\n" + 
                          "\"e\" - 1\n" + 
                          "\"l\" - 3\n" + 
                          "\"o\" - 2\n" + 
                          "\" \" - 1\n" + 
                          "\"w\" - 1\n" + 
                          "\"r\" - 1\n" + 
                          "\"d\" - 1\n" + 
                          "\"!\" - 1";
        assertEquals(expected, counter.printUniqueCharacters(input));
    }
}
