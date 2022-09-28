package lab2;

import java.io.IOException;
import java.util.Scanner;

import static lab2.Lab2.decrypt;
import static lab2.Lab2.encrypt;

public class Test {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nВибір: \n" +
                    "1. Тест із методички\n" +
                    "2. Тест варіанту 12\n" +
                    "3.Зашифрувати\n" +
                    "4.Дешифрувати\n" +
                    "5.Playfair\n" +
                    "6. Вихід з програми\n");
            choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Test 1");
                    System.out.println(encrypt("ТИГР", "ЛЕГІОН_27"));
                    System.out.println(decrypt("тигр", "хндитб4и3ї"));

                    break;
                }
                case 2:
                {System.out.println("Варіант 12");
                    System.out.println(encrypt("БОРИМИР", "ЧОРАПНЕМОРЕ_201"));
                    System.out.println(decrypt("ДИВОЗІР", "ДЗЧЦ_РУ6ЇЗЇЕУНРЮ"));
                    break;}
                case 3:
                {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Шифрування\n");
                    System.out.println("Введіть гамму");
                    String gamma =scanner.nextLine();
                    System.out.println("\nВведіть повідомлення");
                    String massage = scanner.nextLine();
                    System.out.println(encrypt(gamma, massage));
                    break;
                }
                case 4:{
                    System.out.println("Дешифрування\n");
                    System.out.println("Введіть гамму");
                    Scanner scanner = new Scanner(System.in);
                    String gamma =scanner.nextLine();
                    System.out.println("Введіть повідомлення");
                    String massage = scanner.nextLine();
                    System.out.println(decrypt(gamma, massage));
                    break;
                }
                case 5:{
                    String key = "Problem";
                    String plainText1 = "Playfair";

                    System.out.println("Key: " + key);
                    System.out.println("PlainText: " + plainText1);

                    Playfair pfc1 = new Playfair(key, plainText1);
                    pfc1.cleanPlayFairKey();
                    pfc1.generateCipherKey();

                    String encText1 = pfc1.encryptMessage();
                    System.out.println("Cipher Text is: " + encText1);

                }
                case 6: System.exit(0);
                default:
                {System.out.println("Помилка ведіть знову\n");
                    break;
                }
            } // end of switch

        } while (choice!=0); // end of loop


        System.out.println();


    }

}
