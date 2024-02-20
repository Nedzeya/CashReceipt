package com.klachkova.cashReceipt.readerFromFile;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReaderFromFileIntoStringArraySplitEnterTest {
    String filename;
    String[] strings = {""};
    ReaderFromFileIntoStringArraySplitEnter reader = new ReaderFromFileIntoStringArraySplitEnter();
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
    void testFromCharListIntoStringArraySplitEnter(){
        List<Character> characterList = new ArrayList<>();
        characterList.add('1');
        characterList.add('\n');
        characterList.add('2');


      assertEquals(true,reader.fromCharListIntoStringArraySplitEnter(characterList)[1].contains("2"));
    }

    @Test
    void testFromNullCharListIntoStringArraySplitEnter(){
        List<Character> characterList = null;

        assertEquals(strings.getClass(),reader.fromCharListIntoStringArraySplitEnter(characterList).getClass());
    }

    @Test
    void testFromEmptyCharListIntoStringArraySplitEnter(){
        List<Character> characterList = new ArrayList<>();

        assertEquals(strings.getClass(),reader.fromCharListIntoStringArraySplitEnter(characterList).getClass());
    }
}