package com.nexign.yevgenybabkov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_8;

public class WordIndex {

    /** Data structure for storing the contents of an input text file. */
    private Trie trie;

    /**
     * Constructs an index. All words from the input file are stored in the trie
     * with their positions.
     *
     * @param fileName the name of the input file in the "/filename.txt" format,
     *                 which must be located in the "src/main/resources" directory
     */
    public WordIndex(String fileName) {
        trie = new Trie();
        loadFile(fileName);
    }

    private void loadFile(String filename) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        WordIndex.class.getResourceAsStream(filename), UTF_8
                ))
        ) {
            String line, word;
            int wordCount = 0;
            //This pattern allows to get all the words from the file, avoiding special characters
            Pattern pattern = Pattern.compile("[\\w']+");
            Matcher matcher;

            while ( (line = reader.readLine()) != null ) {
                matcher = pattern.matcher(line);

                while (matcher.find()) {
                    word = line.substring( matcher.start(), matcher.end() );
                    trie.insert( word, ++wordCount );
                }
            }
        }
        catch (IOException e) {
            System.err.println("An IOException was caught:" + e.getMessage());
        }
        catch (NullPointerException e) {
            System.err.printf("A file with the name \"%s\" is not found.", filename);
        }
    }

    /**
     * Gets the list of positions of the word in the input file.
     *
     * @param searchWord the search word
     *
     * @return the list of positions for the given word or null if no such
     *         word is found
     */
    public Set<Integer> getIndexes4Word(String searchWord) {
        if (trie != null) {
            TrieNode node = trie.getNode(searchWord);
            if (node != null)
                return node.getIndexes();
        }
        return null;
    }
}
