package com.klachkova.cashReceipt.readerFromFile;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReaderFromFileIntoStringArrayTest {
    String filename;
    String[] strings = {"1"};
    class TestReaderFromFileIntoStringArray implements ReaderFromFileIntoStringArray {

        @Override
        public String[] readFromFile(String fileName) {

            return strings;
        }
    }

    @Test
    void testReadFromFile() {
        ReaderFromFileIntoStringArray readerFromFileIntoStringArray = new TestReaderFromFileIntoStringArray();

        readerFromFileIntoStringArray.readFromFile(filename);
        assertEquals(strings,readerFromFileIntoStringArray.readFromFile(filename));
    }

    @Test
    void testReadingFromNullFileIntoList() {
        ReaderFromFileIntoStringArray readerFromFileIntoStringArray = new TestReaderFromFileIntoStringArray();
        List<Character> characterList = new ArrayList<>();
        filename = null;

        assertEquals(characterList.getClass(),readerFromFileIntoStringArray.readingFromFileIntoList(filename).getClass());


    }

    @Test
    void testReadingFromEmptyFileIntoList() {
        ReaderFromFileIntoStringArray readerFromFileIntoStringArray = new TestReaderFromFileIntoStringArray();
        List<Character> characterList = new ArrayList<>();
        filename = "";

        assertEquals(characterList.getClass(),readerFromFileIntoStringArray.readingFromFileIntoList(filename).getClass());


    }

    @Test
    void testReadingFromUnrealFileIntoList() {
        ReaderFromFileIntoStringArray readerFromFileIntoStringArray = new TestReaderFromFileIntoStringArray();
        List<Character> characterList = new ArrayList<>();
        filename = "Unreal";

        assertEquals(characterList.getClass(),readerFromFileIntoStringArray.readingFromFileIntoList(filename).getClass());


    }
}