package com.nexign.yevgenybabkov;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void trieContainsAllAddedWords() {
        Trie trie = createExampleTrie();

        assertNull(trie.getNode("miss"));
        assertNull(trie.getNode("star"));

        assertNotNull(trie.getNode("No"));
        assertNotNull(trie.getNode("one"));
        assertNotNull(trie.getNode("told"));
        assertNotNull(trie.getNode("you"));
        assertNotNull(trie.getNode("when"));
        assertNotNull(trie.getNode("to"));
        assertNotNull(trie.getNode("run"));
        assertNotNull(trie.getNode("you"));
        assertNotNull(trie.getNode("missed"));
        assertNotNull(trie.getNode("the"));
        assertNotNull(trie.getNode("starting"));
        assertNotNull(trie.getNode("gun"));
    }

    @Test
    public void trieContainsPositionsOfAddedWords() {
        Trie trie = createExampleTrie();
        Set<Integer> indexesForTheWord_You = new LinkedHashSet<>();
        indexesForTheWord_You.add(4);
        indexesForTheWord_You.add(8);

        assertEquals(trie.getNode("you").getIndexes(), indexesForTheWord_You);

        assertNotEquals(trie.getNode("missed").getIndexes(), indexesForTheWord_You);

    }

    private Trie createExampleTrie() {
        Trie trie = new Trie();

        trie.insert("No", 1);
        trie.insert("one", 2);
        trie.insert("told", 3);
        trie.insert("you",4);
        trie.insert("when",5);
        trie.insert("to",6);
        trie.insert("run",7);
        trie.insert("you",8);
        trie.insert("missed",9);
        trie.insert("the",10);
        trie.insert("starting",11);
        trie.insert("gun",12);

        return trie;
    }
}