package com.klachkova.cashReceipt.readerFromFile;

import java.util.List;

public class ReaderFromFileIntoStringArraySplitSpace implements ReaderFromFileIntoStringArray{
    @Override
    public String[] readFromFile(String fileName) {
        return fromCharListIntoStringArraySplitSpace(readingFromFileIntoList(fileName));
    }

    public String [] fromCharListIntoStringArraySplitSpace(List list){

        String string = new String();
      try{  for (Object ch : list) {
            string = string + ch;
        }
      } catch( NullPointerException ex) {
          System.out.println("List shouldn't be null ");
      }

        return string.split(" ");
    }

}
