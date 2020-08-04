package ua.com.foxminded.task5.charcounter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class CharCounter {
    private Map<String, String> cache = new HashMap<>();

    public String printUniqueCharacters(String word) {            
            List<String> inputWord = Arrays.asList(word);
            List<String> outputString = inputWord
                    .stream()
                    .map(wordFromInput -> cache.containsKey(wordFromInput) ? cache.get(wordFromInput) : makeOutputString(wordFromInput))
                    .collect(Collectors.toList());
            String result = outputString.toString();
            return result.substring(1,outputString.toString().length()-2);
        }    

    private Character[] removeDublicateCharacters(Character[] letters) {
        Set<Character> setOfCharWithoutIteration = new LinkedHashSet<>();

        Collections.addAll(setOfCharWithoutIteration, letters);
        Character[] uniqueLetters = setOfCharWithoutIteration.toArray(new Character[0]);
        return uniqueLetters;
    }
    
    private String makeOutputString(String word) {
        StringBuilder result = new StringBuilder();
        char[] letters = word.toCharArray();
        Character[] uniqueLetters = removeDublicateCharacters(ArrayUtils.toObject(letters));
        
        result.append(word + "\n");
        
        Stream<Character> streamOfUniqueCharacter = Arrays.stream(uniqueLetters);
        streamOfUniqueCharacter.forEach(letter ->                
            result.append("\"" + letter + "\"" + " - " + StringUtils.countMatches(word,letter) + "\n")
        ); 
        cache.put(word, result.toString());        
        return result.toString();
    }   
}
