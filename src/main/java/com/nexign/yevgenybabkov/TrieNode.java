package com.nexign.yevgenybabkov;

import java.util.*;

/**
 * A node in a trie.
 */
public class TrieNode {

    /** The word at this node. */
    private String word;

    /** The list of positions of the word in the input file. */
    private Set<Integer> indexes;

    /** The children for the node. */
    private Map<Character, TrieNode> children;

    /**
     * Default constructor.
     */
    public TrieNode() {}

    /**
     * Constructs a node from the given word and its position in the input file.
     *
     * @param word the word
     * @param index the position
     */
    public TrieNode(String word, int index) {
        this.word = word;
        indexes = new LinkedHashSet<>();
        indexes.add(index);
    }

    /**
     * Gets the list of positions of the word in the input file.
     *
     * @return an unmodifiable view on the positions or null
     *         if there is no word stored at this node
     */
    public Set<Integer> getIndexes() {
        if (indexes != null)
            return Collections.unmodifiableSet(indexes);
        return null;
    }

    /**
     * Adds a new position to the word, stored at the node.
     * Do nothing if there is no word associated with the node.
     *
     * @param index the position
     */
    public void addIndex(int index) {
        if (word == null) {
            System.out.println("You cannot add an index to a node that does not associated with any word.");
            return;
        }
        if (indexes == null)
            indexes = new LinkedHashSet<>();
        indexes.add(index);
    }

    /**
     * Gets the word associated with the node.
     *
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the word associated with the node.
     *
     * @param word the word
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Gets the children of the node.
     *
     * @return the list of children
     */
    public Map<Character, TrieNode> getChildren() {
        if (children == null)
            children = new HashMap<>();
        return children;
    }
}