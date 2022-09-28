package lab3;

import java.util.Arrays;
import java.util.Scanner;

import static lab2.Lab2.decrypt;
import static lab2.Lab2.encrypt;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;
        RsaEncrypt rsaEncrypt = new RsaEncrypt();


        do {
            System.out.println("\nВибір: \n" +
                    "1. Тест із методички\n" +
                    "2. Тест варіанту 12\n" +
                    "3. Вихід з програми\n");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("TEST");
                    System.out.println("Шифрування - " + Arrays.toString(RsaEncrypt.encryptRSA("двгупс", 7, 13)));
                    System.out.println("Дешифрування - " + Arrays.toString(rsaEncrypt.decryptRSA(RsaEncrypt.encryptRSA("двгупс", 7, 13), 7, 13)));
                    break;
                }
                case 2: {
                    System.out.println("Варіант - 12");
                    System.out.println("Шифрування - " + Arrays.toString(RsaEncrypt.encryptRSA("ПЕНЯ15", 23, 41)));
                    System.out.println("Дешифрування - " + Arrays.toString(rsaEncrypt.decryptRSA(new int[]{258, 186, 43, 408, 633, 686, 734, 682}, 23, 41)));
                    break;
                }
                case 3: {
                    System.exit(0);
                }
                default: {
                    System.out.println("Помилка!!!! \nВведіть знову варіант з клавіатури");
                    break;
                }
            }
        } while (choice!=0);
        }
    }
