package file;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

class GFG {

    // Function generates the encoded text
    public static String encoder(char[] key, String mes) throws UnsupportedEncodingException {
        String encoded1 = "";
        String encoded = new String(encoded1.getBytes("Cp1251"), "UTF-8");


        boolean[] arr = new boolean[26];

        for (int i = 0; i < key.length; i++) {
            if (key[i] >= 'А' && key[i] <= 'Я') {
                // To check whether the character is inserted
                // earlier in the encoded string or not
                if (arr[key[i] - 65] == false) {
                    encoded += (char) key[i];
                    arr[key[i] - 65] = true;
                }
            } else if (key[i] >= 'а' && key[i] <= 'я') {
                if (arr[key[i] - 97] == false) {
                    encoded += (char) (key[i] - 32);
                    arr[key[i] - 97] = true;
                }
            }
        }

        // This loop inserts the remaining
        // characters in the encoded string.
        for (int i = 0; i < 26; i++) {
            if (arr[i] == false) {
                arr[i] = true;
                encoded += (char) (i + 65);
            }
        }
        return encoded;
    }

    // This function will decode the message
    public static String decipheredIt(String msg, String input) throws UnsupportedEncodingException {

        String plaintext0 = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
        String decipher0 = "";
        String plaintext = new String(plaintext0.getBytes("Cp1251"), "UTF-8");
        String decipher = new String(decipher0.getBytes("Cp1251"), "UTF-8");


        Map<Character, Integer> enc = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            enc.put(input.charAt(i), i);
        }

        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) >= 'А' && msg.charAt(i) <= 'Я') {
                int pos = enc.get((char) (msg.charAt(i) - 32));
                decipher += plaintext.charAt(pos);
            } else if (msg.charAt(i) >= 'а' && msg.charAt(i) <= 'я') {
                int pos = enc.get(msg.charAt(i));
                decipher += plaintext.charAt(pos);
            } else {
                decipher += msg.charAt(i);
            }
        }
        return decipher;
    }
}
