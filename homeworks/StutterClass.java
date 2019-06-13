import java.util.*;
public class StutterClass {

    public static void main(String[] args) {

        System.out.println(stutter("hello"));

    }

    public static String stutter(String word){

        int wordLength = word.length();
        String stutteredWord = "";
        for(int i = 0; i < wordLength; i++) {
            stutteredWord = stutteredWord + word.substring(i, i+1).repeat(2);
            System.out.println(stutteredWord);
            }
        return stutteredWord;
        }
    }

