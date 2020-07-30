package ua.com.foxminded.task5.charcounter;

import java.util.*;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class CharCounter {
    private Map<String, String> cache = new HashMap<>();

    public String countLetters(String word) {

        if (!cache.containsKey(word)) {
            StringBuilder result = new StringBuilder();
            char[] letters = word.toCharArray();
            Character[] uniqueLetters = returnUniqueLetters(ArrayUtils.toObject(letters));
            int matchesInWord;
            result.append(word + "\n");
            for (int pointer = 0; pointer < uniqueLetters.length; pointer++) {
                matchesInWord = StringUtils.countMatches(word, uniqueLetters[pointer]);
                result.append("\"" + uniqueLetters[pointer] + "\"" + " - " + matchesInWord + "\n");
            }

            cache.put(word, result.toString());
            return result.toString();

        } else {
            return cache.get(word);
        }
    }

    private Character[] returnUniqueLetters(Character[] letters) {
        Set<Character> set = new LinkedHashSet<>();

        Collections.addAll(set, letters);
        Character[] uniqueLetters = set.toArray(new Character[0]);
        return uniqueLetters;
    }
}
