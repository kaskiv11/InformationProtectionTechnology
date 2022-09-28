package lab2;


public class Lab2 {


    public static String encrypt(String gamma, String massage) {
        String res = "";
        String abc = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя_0123456789";

        char[] chABC = abc.toCharArray();
        char[] chMassage = massage.toLowerCase().toCharArray(); // у нижньому регістрі
        char[] chGamma = gamma.toLowerCase().toCharArray();
        int[] m = new int[chMassage.length];
        int[] g = new int[chGamma.length];
        int[] c = new int[chMassage.length];

        for (int i = 0; i < chGamma.length; i++) {
            int index = 0;
            while (chGamma[i] != chABC[index]) index++;
            if (index > 43) {
                index -= 43;
            }
            g[i] = index;
        }
        for (int i = 0; i < chMassage.length; i++) {
            int index = 0;
            while (chMassage[i] != chABC[index]) index++;
            if (index > 43) {
                index -= 43;
            }
            m[i] = index;
        }
        int index = 0;
        for (int i = 0; i < m.length; i++) {
            c[i] = (m[i] + g[index++]) % chABC.length;
            if (index > chGamma.length - 1) index = 0;
        }

        for (int i = 0; i < c.length; i++) {
            System.out.print(chABC[c[i] + 1]);
        }
        return "";
    }


    public static String decrypt(String gamma, String massage) {
        String res = "";
        String abc = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя_0123456789";
        char[] chABC = abc.toCharArray();
        char[] chMassage = massage.toLowerCase().toCharArray();
        char[] chGamma = gamma.toLowerCase().toCharArray();
        int[] m = new int[chMassage.length];
        int[] g = new int[chGamma.length];
        int[] c = new int[chMassage.length];

        for (int i = 0; i < chGamma.length; i++) {
            int index = 0;
            while (chGamma[i] != chABC[index]) index++;
            if (index > 43) {
                index -= 43;
            }

            g[i] = index;
        }
        for (int i = 0; i < chMassage.length; i++) {
            int index = 0;
            while (chMassage[i] != chABC[index]) index++;
            if (index > 43) {
                index -= 43;
            }

            m[i] = index;
        }
        int index = 0;
        for (int i = 0; i < m.length; i++) {
            c[i] = ((m[i] - g[index++]) + 43) % chABC.length;
            if (c[i] == 0) c[i] = 44;
            if (index > chGamma.length - 1) index = 0;
        }

        for (int i = 0; i < c.length; i++) {
            System.out.print(chABC[c[i]]);
        }
        return "";
    }

}

