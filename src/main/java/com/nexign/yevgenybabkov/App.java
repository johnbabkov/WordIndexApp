package com.nexign.yevgenybabkov;

public class App {

    public static String FILE_NAME = "/test.txt";

    public static void main( String[] args ) {
        WordIndex wordIndex = new WordIndex(FILE_NAME);
        System.out.println(wordIndex.getIndexes4Word("the"));
    }
}
