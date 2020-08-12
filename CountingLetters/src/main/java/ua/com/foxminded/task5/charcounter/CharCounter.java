package ua.com.foxminded.task5.charcounter;

import java.util.*;
import java.util.stream.Collectors;

public class CharCounter {
    private Map<String, String> cache = new HashMap<>();

    public String printUniqueCharacters(String inputWord) {
        String outputString = cache.computeIfAbsent(inputWord, word -> makeOutputString(word));
        return outputString.substring(0, outputString.length() - 1);
    }

    private String makeOutputString(String word) {
        StringBuilder result = new StringBuilder();

        List<Character> inputWord = word
                .chars()
                .mapToObj(letter -> Character.valueOf((char) letter))
                .collect(Collectors.toList());
        Set<Character> setOfCharWithoutIteration = new LinkedHashSet<>(inputWord);
        Map<Character, Long> numbersOfOccurrences = inputWord
                .stream()
                .collect(Collectors.groupingBy(letter -> letter, Collectors.counting()));

        result.append(word + "\n");
        setOfCharWithoutIteration.forEach(
                letter -> result.append("\"" + letter + "\"" + " - " + numbersOfOccurrences.get(letter) + "\n"));

        cache.put(word, result.toString());
        return result.toString();
    }
}
