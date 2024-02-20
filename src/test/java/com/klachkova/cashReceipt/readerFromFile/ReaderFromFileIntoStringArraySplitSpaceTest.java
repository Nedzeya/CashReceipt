package com.klachkova.cashReceipt.readerFromFile;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReaderFromFileIntoStringArraySplitSpaceTest {

    String filename;
    String[] strings = {""};
    ReaderFromFileIntoStringArraySplitSpace reader = new ReaderFromFileIntoStringArraySplitSpace();

    @Test
    void testReadFromNullFile() {

        filename = null;

        assertEquals(strings.getClass(), reader.readFromFile(filename).getClass());

    }

    @Test
    void testReadFromEmptyFile() {

        filename = "";

        assertEquals(strings.getClass(), reader.readFromFile(filename).getClass());

    }

    @Test
    void testReadFromUnrealFile() {

        filename = "Unreal";

        assertEquals(strings.getClass(), reader.readFromFile(filename).getClass());

    }


    @Test
    void testFromCharListIntoStringArraySplitSpace() {
        List<Character> characterList = new ArrayList<>();
        characterList.add('1');
        characterList.add(' ');
        characterList.add('2');


        assertEquals(true, reader.fromCharListIntoStringArraySplitSpace(characterList)[1].contains("2"));
    }

    @Test
    void testFromNullCharListIntoStringArraySplitSpace() {
        List<Character> characterList = null;

        assertEquals(strings.getClass(), reader.fromCharListIntoStringArraySplitSpace(characterList).getClass());
    }

    @Test
    void testFromEmptyCharListIntoStringArraySplitSpace() {
        List<Character> characterList = new ArrayList<>();

        assertEquals(strings.getClass(), reader.fromCharListIntoStringArraySplitSpace(characterList).getClass());
    }


}