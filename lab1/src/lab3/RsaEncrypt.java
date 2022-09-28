package lab3;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class RsaEncrypt {

    static int greatestCommonDenominator(int e, int z) {// метод для найбільшого спільного дільника
        if (e == 0)
            return z;
        else
            return greatestCommonDenominator(z % e, e);
    }

    public static int[] encryptRSA(String massage, int p, int g) {
        String ukrainianABC = "абвгдеїжзийклмнопрстуфхцчшщєґьіюя_0123456789";
        char[] charsUkrainianABC = ukrainianABC.toCharArray();
        int e;
        char[] charArrayMassages = massage.toCharArray();
        int[] m = new int[charArrayMassages.length];

        int n = p * g;
        int z = (p - 1) * (p - 1);

        for (e = 2; e < z; e++) {
            if (greatestCommonDenominator(e, z) == 1)            // Тут міститься публічний відкритий  ключ
            {
                break;
            }
        }

        int d = 0;
        for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            if (x % e == 0)      //d закритий ключ
            {
                d = x / e;
                break;
            }
        }

        for (int i = 0; i < charArrayMassages.length; i++) {
            int index = 0;
            while (charArrayMassages[i] != charArrayMassages[index]) index++;
            if (index > 43) {
                index -= 43;
            }
            m[i] = index + 1;
        }

        int[] arraysInt = new int[charArrayMassages.length];
        for (int i = 0; i < charArrayMassages.length; i++) {
            arraysInt[i] = (int) (Math.pow(m[i], e) % n);
        }

        return arraysInt;
    }


    public  char[] decryptRSA(int[] massage, int p, int g) {
        String abcUkr = "абвгдеїжзийклмнопрстуфхцчшщєґьіюя_0123456789";
        char[] charArraysABCUkr = abcUkr.toLowerCase().toCharArray();
        int n = g * g;
        int z = (p - 1) * (p - 1);
        int e;

        for (e = 2; e < z; e++) {
            if (greatestCommonDenominator(e, z )== 1)            //публічний ключ через найбльший спільник дільник
            {
                break;
            }
        }

        int d = 0;
        for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            if (x % e == 0)      //d через закритий ключ
            {
                d = x / e;
                break;
            }
        }

        char[] decrypt = new char[massage.length];

        for (int i = 0; i < massage.length; i++) {
            BigInteger C = BigDecimal.valueOf(massage[i]).toBigInteger();
            BigInteger N = BigInteger.valueOf(n);
            BigInteger msgback = (C.pow(d)).mod(N);

            int[] bitArraysInt = new int[massage.length];
            bitArraysInt[i] = msgback.intValue();

            if (bitArraysInt[i] > 43) {
                bitArraysInt[i] %= 43;
            }


            decrypt[i] = charArraysABCUkr[bitArraysInt[i] - 1];
        }
        return decrypt;
    }

}