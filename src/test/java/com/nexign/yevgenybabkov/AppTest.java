package com.nexign.yevgenybabkov;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertTrue;

public class AppTest
{
    private WordIndex wordIndex;

    @Before
    public void init() {
        wordIndex = new WordIndex(App.FILE_NAME);
    }

    @After
    public void tearDown() {
        wordIndex = null;
    }

    @Test
    public void allWordsContainsInTrie() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        WordIndex.class.getResourceAsStream(App.FILE_NAME), UTF_8
                ))
        ) {
            String line, word;
            int wordCount = 0;
            Pattern pattern = Pattern.compile("[\\w']+");
            Matcher matcher;

            while ((line = reader.readLine()) != null) {
                matcher = pattern.matcher(line);

                while (matcher.find()) {
                    word = line.substring(matcher.start(), matcher.end());
                    assertTrue(wordIndex.getIndexes4Word(word).contains(++wordCount));
                }
            }
        }
        catch (IOException e) {
            System.err.println("An IOException was caught:" + e.getMessage());
        }
        catch (NullPointerException e) {
            System.err.printf("A file with the name \"%s\" is not found.", App.FILE_NAME);
        }
    }

}
