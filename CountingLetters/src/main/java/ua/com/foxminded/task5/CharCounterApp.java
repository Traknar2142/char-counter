package ua.com.foxminded.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.task5.charcounter.CharCounter;

public class CharCounterApp {

    public static void main(String[] args) throws IOException {
        CharCounter charCounter = new CharCounter();
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        List<String> words = new ArrayList<>();

        System.out.println("enter words through Enter\n" + "To end input enter 'stop'");
        String inputWord = reader.readLine();

        while (!inputWord.equals("stop")) {
            words.add(inputWord);
            inputWord = reader.readLine();
        }

        for (String word : words) {
            System.out.println(charCounter.printUniqueCharacters(word));
        }
    }
}
