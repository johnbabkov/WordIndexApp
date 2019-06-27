package com.nexign.yevgenybabkov;

/**
 * A trie.
 */
public class Trie {

    /** The root node in the trie. */
    private TrieNode root;

    /** The number of words stored in the trie. */
    private int size;

    /**
     * Default constructor.
     */
    public Trie() {
        this.root = new TrieNode();
        this.size = 0;
    }

    /**
     * Adds a word along with its position in the file to the trie.
     *
     * @param word the word
     * @param index the position
     */
    public void insert(String word, int index) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }

        if (current.getWord() == null) {
            current.setWord(word);
            this.size++;
        }
        current.addIndex(index);
    }

    /**
     * Searching for a word in the trie.
     *
     * @param word the word
     * @return the node matches the word or null
     *         if there is no such word stored in the trie
     */
    public TrieNode getNode(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            current = current.getChildren().get(word.charAt(i));
            if (current == null)
                return null;
        }
        if (current.getWord() != null)
            return current;
        else
            return null;
    }

    /**
     * Gets the number of words stored in the trie.
     *
     * @return the size
     */
    public int getSize() {
        return this.size;
    }

}
