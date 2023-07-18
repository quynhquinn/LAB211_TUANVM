package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import view.CountView;
import util.Inputter;

public class CountController {

    private Map<Character, Integer> charCounter = new HashMap<>();
    private Map<String, Integer> wordCounter = new HashMap<>();

    //Ham dung de dem cac tu
    private void countWord(String content) {
        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCounter.containsKey(token)) {
                wordCounter.put(token, 1);
            } else {
                wordCounter.put(token, ((int) wordCounter.get(token)) + 1);
            }
        }
    }

    //Ham dung de dem cac chu cai
    private void countChar(String content) {
        //Đếm chữ cái
        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                continue;
            }
            if (!charCounter.containsKey(ch)) {
                charCounter.put(ch, 1);
            } else {
                charCounter.put(ch, ((int) charCounter.get(ch)) + 1);
            }
        }
    }

    //Dieu khien
    public void handleApp() {
        Inputter inputter = new Inputter();
        CountView countView = new CountView();
        
        //Cho nguoi dung nhap vao 1 string
        String content = inputter.inputString("Enter your content: ");

        //Thuc hien dem tu va dem chu cai
        countWord(content); //Dem tu
        countChar(content); //Dem chu cai

        //In ra cac tu va chu cai sau khi dem duoc
        countView.displayWord(wordCounter); //In ra cac tu
        countView.displayChar(charCounter); //In ra cac chu cai 
    }
}
