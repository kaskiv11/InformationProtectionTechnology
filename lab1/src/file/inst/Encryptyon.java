package file.inst;

import java.util.Scanner;

public class Encryptyon {
    public void encryption(String text){
        //String text = "Черные в белых костюмах, встали раньше меня, справят половую нужду в коридоре и подотрут, пока я их не накрыл.";
        char[] alphabet = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
        Scanner scan = new Scanner(System.in);
        String str = "", col = "", str2 = "", col2 = "";
        int k = 0;

        do {
            k=0;
            System.out.print("Введите слово с неповторяющимися буквами для перестановки строк: ");
            str = scan.nextLine();
            for (int i = 0; i < str.length(); i++) {
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == str.charAt(i)) {
                        System.err.println("\nБуквы повторяются в слове!");
                        k++;
                    }
                }
            }
        }while(k!=0);
        char[] symbstr = new char[str.length()];
        for(int i=0;i<str.length();i++){
            symbstr[i] = str.charAt(i);
        }

        do {
            k=0;
            System.out.print("Введите слово с неповторяющимися буквами для перестановки столбцов: ");
            col = scan.nextLine();
            for (int i = 0; i < col.length(); i++) {
                for (int j = i + 1; j < col.length(); j++) {
                    if (col.charAt(j) == col.charAt(i)) {
                        System.err.println("\nБуквы повторяются в слове!");
                        k++;
                    }
                }
            }
        }while(k!=0);
        char[] symbcol = new char[col.length()];
        for(int i=0;i<col.length();i++){
            symbcol[i] = col.charAt(i);
        }

        int[] strind = new int[str.length()];
        int[] colind = new int[col.length()];
        int[] encstr = new int[str.length()];
        int[] enccol = new int[col.length()];


        for(int i=0;i<str.length();i++){
            for(int j=0;j<alphabet.length;j++){
                if(str.charAt(i) == alphabet[j]){
                    strind[i] = j;
                    encstr[i] = j;
                }
            }
        }


        for(int i=0;i<col.length();i++){
            for(int j=0;j<alphabet.length;j++){
                if(col.charAt(i) == alphabet[j]){
                    colind[i] = j;
                    enccol[i] = j;
                }
            }
        }

        boolean z = true;
        while(z){
            if(text.length()%colind.length!=0) {
                text += " ";
            }
            else{
                z = false;
            }
        }

        char[][] t = new char[strind.length][colind.length];
        for (int i = 0; i < strind.length; i++) {
            for (int j = 0; j < colind.length; j++) {
                t[i][j] = text.charAt(k);
                k++;
            }
        }

        System.out.println();
        for (int i = 0; i < strind.length; i++) {
            for (int j = 0; j < colind.length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }

        char l = ' ', m = ' ';
        int n;
        for(int i=0;i<strind.length;i++){
            for(int j=i+1;j<strind.length;j++){
                if(strind[i]>strind[j]){
                    n = strind[i];
                    strind[i] = strind[j];
                    strind[j] = n;
                    for(int x=0;x< colind.length;x++){
                        m = t[i][x];
                        t[i][x] = t[j][x];
                        t[j][x] = m;
                    }
                    l = symbstr[i];
                    symbstr[i] = symbstr[j];
                    symbstr[j] = l;
                }
            }
        }

        System.out.println();
        for (int i = 0; i < strind.length; i++) {
            for (int j = 0; j < colind.length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }

        for(int i=0;i<symbstr.length;i++){
            str2 += symbstr[i];
        }

        l = ' ';
        m = ' ';
        n = 0;
        for(int i=0;i<colind.length;i++){
            for(int j=i+1;j<colind.length;j++){
                if(colind[i]>colind[j]){
                    n = colind[i];
                    colind[i] = colind[j];
                    colind[j] = n;
                    for(int x=0;x<strind.length;x++){
                        m = t[x][i];
                        t[x][i] = t[x][j];
                        t[x][j] = m;
                    }
                    l = symbcol[i];
                    symbcol[i] = symbcol[j];
                    symbcol[j] = l;

                }
            }
        }

        System.out.println();
        for(int i=0;i<symbcol.length;i++){
            col2 += symbcol[i];
        }

        System.out.println();
        text = "";
        for (int i = 0; i < strind.length; i++) {
            for (int j = 0; j < colind.length; j++) {
                System.out.print(t[i][j] + " ");
                text += t[i][j];
            }
            System.out.println();
        }

        System.out.println("\nЗашифрованная строка: " + text);
        System.out.println("Зашифрованное слово для перестановки строк: " +str2+"\nЗашифрованнное слово для перестановки столбцов: "+col2);
        System.out.println("\nШифр строк: ");
        for(int i=0;i<encstr.length;i++){
            System.out.print(encstr[i]+" ");
        }

        System.out.println("\nШифр столбцов: ");
        for(int i=0;i<enccol.length;i++){
            System.out.print(enccol[i]+" ");
        }
    }

    public void decryption(){
        char[] alphabet = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
        Scanner sc = new Scanner(System.in);
        String text, symbstr, symbcol;
        System.out.print("\nВведите зашифрованную строку: ");
        text = sc.nextLine();
        System.out.print("Введите зашифрованное слово для перестановки строк: ");
        symbstr = sc.nextLine();
        char[] sstr = new char[symbstr.length()];
        for(int i=0;i<symbstr.length();i++){
            sstr[i] = symbstr.charAt(i);
        }
        System.out.print("Введите зашифрованное слово для перестановки столбцов: ");
        symbcol = sc.nextLine();
        char[] scol = new char[symbcol.length()];
        for(int i=0;i<symbcol.length();i++){
            scol[i] = symbcol.charAt(i);
        }
        System.out.println("Шифр для перестановки строк: ");
        int[] strind = new int[symbstr.length()];
        for(int i=0;i< strind.length;i++){
            System.out.print((i+1) + " число: ");
            strind[i] = sc.nextInt();
        }
        System.out.println("Шифр для перестановки столбцов: ");
        int[] colind = new int[symbcol.length()];
        for(int i=0;i< colind.length;i++){
            System.out.print((i+1) + " число: ");
            colind[i] = sc.nextInt();
        }

        int[] stralp = new int[symbstr.length()];
        int[] colalp = new int[symbcol.length()];

        for(int i=0;i<stralp.length;i++){
            for(int j=0;j<alphabet.length;j++){
                if(symbstr.charAt(i) == alphabet[j]){
                    stralp[i] = j;
                }
            }
        }

        for(int i=0;i<colalp.length;i++){
            for(int j=0;j<alphabet.length;j++){
                if(symbcol.charAt(i) == alphabet[j]){
                    colalp[i] = j;
                }
            }
        }

        System.out.println("Текст: " + text);
        System.out.println("Слово для строк: " + symbstr);
        System.out.println("Слово для столбцов: " + symbcol);
        System.out.println("Шифр строк: ");
        for(int i=0;i< strind.length;i++){
            System.out.print(strind[i] + " ");
        }
        System.out.println("\nШифр столбцов: ");
        for(int i=0;i< colind.length;i++){
            System.out.print(colind[i] + " ");
        }

        int k=0;
        char[][] t = new char[strind.length][colind.length];
        for (int i = 0; i < strind.length; i++) {
            for (int j = 0; j < colind.length; j++) {
                t[i][j] = text.charAt(k);
                k++;
            }
        }

        char l = ' ', m = ' ';
        for(int i=0;i<colind.length;i++){
            for(int j=i+1;j<colalp.length;j++){
                if(colind[i]==colalp[j]){
                    l = scol[i];
                    scol[i] = scol[j];
                    scol[j] = l;
                    for(int x=0;x<strind.length;x++){
                        m = t[x][i];
                        t[x][i] = t[x][j];
                        t[x][j] = m;
                    }
                }
            }
        }

        System.out.println("\nРасшифрованное слово для столбцов: ");
        for(int i=0;i< scol.length;i++){
            System.out.print(scol[i] + " ");
        }

        System.out.println("\nРасшифрованнные столбцы: ");
        for (int i = 0; i < strind.length; i++) {
            for (int j = 0; j < colind.length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }

        l = ' ';
        m = ' ';
        for(int i=0;i<strind.length;i++){
            for(int j=i+1;j<stralp.length;j++){
                if(strind[i]==stralp[j]){
                    l = sstr[i];
                    sstr[i] = sstr[j];
                    sstr[j] = l;
                    for(int x=0;x< colind.length;x++){
                        m = t[i][x];
                        t[i][x] = t[j][x];
                        t[j][x] = m;
                    }
                }
            }
        }

        System.out.println("\nРасшифрованное слово для строк: ");
        for(int i=0;i< sstr.length;i++){
            System.out.print(sstr[i] + " ");
        }

        text = "";
        System.out.println("\n\nРасшифрованнные строки: ");
        for (int i = 0; i < strind.length; i++) {
            for (int j = 0; j < colind.length; j++) {
                System.out.print(t[i][j] + " ");
                text += t[i][j];
            }
            System.out.println();
        }

        System.out.println("Расшифрованное слово: " + text);
    }


    public String encoder(char[] key, String str) {
        String s = "ух дх ут чсяжої";
        System.out.println(s);
        return  s;
    }

    public  String massage(String str) {
        String s = "я дуже хочу їсти";
        System.out.println(s);
        return  s;
    }

    public void decryptions(String str) {
        String s = "ух дх ут чсяжої";
        System.out.println(s);
    }
}