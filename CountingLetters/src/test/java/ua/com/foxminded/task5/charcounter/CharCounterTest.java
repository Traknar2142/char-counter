package ua.com.foxminded.task5.charcounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CharCounterTest {
    CharCounter counter = new CharCounter();
    
    @Test
    void countLetters_ShouldReturnNothing_WhenInputIsNothing() {
        String input = "";
        String expected = "\n";
        assertEquals(expected, counter.countLetters(input));
    }
    
    @Test
    void countLetters_ShouldReturnColumnWithOne_WhenInputIsOne() {
        String input = "1";
        String expected = "1\n" + 
                          "\"1\" - 1\n";
        assertEquals(expected, counter.countLetters(input));
    }
    
    @Test
    void countLetters_ShouldReturnColumnWithOneAndSpace_WhenInputIsSixUnitsSeparatedBySpace() {
        String input = "111 111";
        String expected = "111 111\n" + 
                          "\"1\" - 6\n" +
                          "\" \" - 1\n";
        assertEquals(expected, counter.countLetters(input));
    }
    
    @Test
    void countLetters_ShouldReturnColumnWithOne_WhenInputIsThreeUnits() {
        String input = "111";
        String expected = "111\n" + 
                          "\"1\" - 3\n";
        assertEquals(expected, counter.countLetters(input));
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
                          "\"+\" - 2\n";
        assertEquals(expected, counter.countLetters(input));
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
                          "\"!\" - 1\n";
        assertEquals(expected, counter.countLetters(input));
    }
}
