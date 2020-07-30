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
        String word = reader.readLine();

        while (!word.equals("stop")) {
            words.add(word);
            word = reader.readLine();
        }

        for (String wordFromList : words) {
            System.out.println(charCounter.countLetters(wordFromList));
        }
    }
}