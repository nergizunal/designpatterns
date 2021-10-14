import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.*;

public class BuyukUnluUyumu {
    public static void main(String[] args){
        System.out.println("Bir kelime giriniz: ");
        Locale loc = new Locale("tr", "TR");
        Scanner scan = new Scanner(System.in, "UTF-8");
        scan.useLocale(loc);
        //String word;
        String word = scan.next();
        System.out.println(word);
        //check(word);

        boolean kalin = word.matches(".*[AIOUaıou].*");
        boolean ince = word.matches(".*[EİÖÜeiöü].*");
        boolean sesliHarf = kalin || ince;
        if(ince && kalin){
            System.out.println("Uyumsuz.");
        }
        else if (sesliHarf)
        {
            System.out.println("Uyumlu.");
        }
        else
            System.out.println("Sesli Harf Bulunmuyor.");
    }
    public static void check(String str){
        String[] harfArray = new String[str.length()];
        for (int j = 0; j < str.length(); j++)
            harfArray[j] = str.substring(j, j + 1);


        boolean kalin = isTheraAKalin(harfArray);
        boolean ince = isTheraAInce(harfArray);
        boolean sesliHarf = kalin || ince;
        System.out.println(ince + " " + kalin);
        if(ince && kalin){
            System.out.println("Uyumsuz.");
        }
        else if (sesliHarf)
        {
            System.out.println("Uyumlu.");
        }
        else
            System.out.println("Sesli Harf Bulunmuyor.");

    }
    public static boolean isTheraAKalin(String[] str){
        String[] kalin = new String[]{"A", "I", "O", "U", "a", "ı", "o", "u"};

        for(String c: str) {
            for (String c2 : kalin) {
                if (c.equals(c2))
                    return true;
            }
        }
        return false;
    }
    public static boolean isTheraAInce(String[] str){
        String[] ince = new String[]{"E", "İ", "Ö", "Ü", "e", "i", "ö", "ü"};

        for(String c: str) {
            for (String c2 : ince) {
                if (c.equals(c2))
                    return true;
            }
        }
        return false;
    }

}
