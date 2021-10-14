
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author tuyucel
 */
public class denem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("L�tfen bir kelime giriniz: ");

        Scanner scn = new Scanner(System.in);
        String girilenKelime = scn.next();
        UnluUyumu(girilenKelime);
    }

    public static void UnluUyumu(String kelime) {
        String[] Kalin = new String[]{"A", "I", "O", "U", "a", "�", "o", "u"};
        String[] Ince = new String[]{"E", "�", "�", "�", "e", "i", "�", "�"};
        String[] Harfler = new String[kelime.length()];

        int kalin = 0;
        int ince = 0;

        for (int j = 0; j < kelime.length(); j++) {
            Harfler[j] = kelime.substring(j, j + 1);
        }

        for (String harf1 : Harfler) {
            for (String harf2 : Kalin) {
                if (harf1.equals(harf2)) {
                    kalin++;
                }
            }
            for (String harf3 : Ince) {
                if (harf1.equals(harf3)) {
                    ince++;
                }
            }
        }

        switch (kalin + ince) {
            case 1:
                System.out.println("Tek heceli kelimelerde b�y�k �nl� uyumu aranmaz.");
                break;
            case 0:
                System.out.println("Sesli harf i�eren bir kelime giriniz.");
                break;
            default:
                if (kalin > 0 && ince > 0) {
                    System.out.println("B�y�k �nl� uyumuna uymaz.");
                }
                if (kalin > 0 && ince <= 0) {
                    System.out.println("B�y�k �nl� uyumuna uyar.");
                }
                if (ince > 0 && kalin <= 0) {
                    System.out.println("B�y�k �nl� uyumuna uyar.");
                }
                break;
        }
    }
}
