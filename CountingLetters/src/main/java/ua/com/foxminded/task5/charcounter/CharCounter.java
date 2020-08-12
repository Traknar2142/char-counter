package ua.com.foxminded.task5.charcounter;

import java.util.*;
import java.util.stream.Collectors;

public class CharCounter {
    private Map<String, String> cache = new HashMap<>();

    public String printUniqueCharacters(String inputString) {
        String outputString = cache.computeIfAbsent(inputString, string -> makeOutputString(string));
        return outputString;
    }

    private String makeOutputString(String word) {
        StringBuilder result = new StringBuilder();

        List<Character> inputString = word
                .chars()
                .mapToObj(letter -> Character.valueOf((char) letter))
                .collect(Collectors.toList());
        Set<Character> setOfChars = new LinkedHashSet<>(inputString);
        Map<Character, Long> frequency = inputString
                .stream()
                .collect(Collectors.groupingBy(letter -> letter, Collectors.counting()));

        result.append(word + "\n");
        setOfChars.forEach(
                letter -> result.append("\"" + letter + "\"" + " - " + frequency.get(letter) + "\n"));
        String resultString = result.toString().substring(0, result.toString().length() - 1);
        return resultString;
    }
}
