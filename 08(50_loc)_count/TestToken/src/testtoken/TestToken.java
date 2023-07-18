
package testtoken;
import java.util.*;
public class TestToken {

    public static void main(String[] args) {
        //1. Input the string value
        String StringValue= InputStringValue("Enter your content: ");
        //2.Count the number of letters 
        HashMap<String, Integer> LetterCount= CountLetter( StringValue);
        //3. Count the number of character
        HashMap<Character, Integer> CharCount = CountChar(StringValue);
        // 4.Display number of letters
        DisplayNumOfLetters(LetterCount);
        //5. Display number of character
        DisplayNumOfChar(CharCount);
    }
        public static String InputStringValue( String s) {
            String temp;
            Scanner sc= new Scanner(System.in);
            do{
                    System.out.print(s);
                    temp= sc.nextLine().trim();
            //regex: a-zA-Z: contain both caps and normal character
            // 0-9 : contain number
            // \\s : space
            // +: appear one or more than
            }while(temp.isEmpty()==true || !temp.matches("^[a-zA-Z0-9\\s]+$"));
            return temp; 
 }
 
        public static HashMap<String, Integer>  CountLetter(String s){
            HashMap<String, Integer> LetterCount= new HashMap<>();
            StringTokenizer token = new StringTokenizer(s);
            while (token.hasMoreTokens()){
                String temp=token.nextToken();
                if (LetterCount.containsKey(temp)==false){
                    LetterCount.put(temp, 1);
                }
                else {
                    LetterCount.put(temp, LetterCount.get(temp)+1);
                }
            }
        return LetterCount;
        }
        public static HashMap<Character, Integer> CountChar( String s) {
            HashMap<Character, Integer> CharCount=new HashMap<>();
            char[] ch= s.toCharArray();
            for ( int i=0; i<ch.length;i++){
                if (ch[i]==' ') continue;
                if (CharCount.containsKey(ch[i])==false) {
                    CharCount.put(ch[i], 1);
                }
                else CharCount.put(ch[i],CharCount.get(ch[i])+1);
            }
            return CharCount;
        }
        public static void DisplayNumOfLetters(HashMap<String, Integer> LetterCount){
            System.out.println(LetterCount);
        } 
        public static void DisplayNumOfChar( HashMap<Character, Integer> CharCount){
            System.out.println(CharCount);
        }
        
}

