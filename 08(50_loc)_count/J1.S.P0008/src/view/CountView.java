
package view;

import java.util.Map;

public class CountView {

    //Hien thi tu
    public void displayWord(Map<String, Integer> wordCounter) {
        System.out.println(wordCounter);
    }

    //Hien thi chu cai
    public void displayChar(Map<Character, Integer> charCounter) {
        System.out.println(charCounter);
    }

}
