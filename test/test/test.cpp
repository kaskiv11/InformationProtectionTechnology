//#include "stdafx.h"
#include <iostream> //вывод в консоль
#include <cstdlib> // для использования функции exit()
#include <stdio.h> //необходимо для printf

using namespace std;

int main()
{
    setlocale(LC_ALL, "Russian"); // корректное отображение Кириллицы

    /*инициализируем переменные*/

    int k = 3; // шаг (ключ) для шифра Цезаря
    int b = 9; // количество строк
    int c = 5; // количество столбцов

    char alf[140] = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюяABCDEFGHIJKLMNOPQRSTUVWXYZabcedfghijklmnopqrstuvwxyz0123456789.,!?@#$%^&*"; //словарь

    string buf = "Почему, ты. не компилируешься? А вот не хочу!"; // исходный текст
    printf("Исходный текст = ");
    cout << buf;

    int skokslov = buf.size(); // считает количество слов в данном тексте (45)

    printf("\n***Шифрование***");

    int i = 0; // для массива словаря
    int n = 0; // для массива текста
    for (n = 0; n < skokslov; n++)
    {
        for (i = 0; i < 139; i++)
        {
            if (buf[n] == alf[i])
            {
                if (i >= 140 - k + 1)
                    buf[n] = alf[i - 140 - k];
                else
                    buf[n] = alf[i + k]; //сдвигаем вправо на показания шага ключа
                break; //принудительно выходим из цикла
            }
        }
    }
    printf("\nШифр Цезаря зашифрованный = ");
    cout << buf; //выводим полученный шифр

    char massiv[100][100]; // для представления двумерного массива
    int count = 0; // для перебора поэлементно в массив
    for (int i = 0; i < b; i++)
    {
        for (int j = 0; j < c; j++)
        {
            massiv[i][j] = buf[count];
            count++;
        }
    }
    cout << "\nШифр перестановки зашифрованный = ";
    for (int j = 0; j < c; j++)
    {
        for (int i = 0; i < b; i++)
        {
            cout << massiv[i][j];
        }
    }

    printf("\n***Дешифрование***\n");

    int amaunt = 0; // для перебора поэлементно из массива
    for (int i = 0; i < b; i++)
    {
        for (int j = 0; j < c; j++)
        {
            buf[amaunt] = massiv[i][j];
            amaunt++;
        }
    }
    cout << "Шифр перестановки дешифрованный = ";
    for (int j = 0; j < c; j++)
    {
        for (int i = 0; i < b; i++)
        {
            cout << buf[amaunt];
        }
    }
    cout << buf;

    for (n = 0; n < skokslov; n++)
    {
        for (i = 0; i < 139; i++)
        {
            if (buf[n] == alf[i])
            {
                if (i >= 140 - k + 1)
                    buf[n] = alf[i - 140 - k];
                else
                    buf[n] = alf[i - k]; //сдвигаем влево на показания шага ключа
                break; //принудительно выходим из цикла
            }
        }
    }
    printf("\nШифр Цезаря дешифрованный = ");
    cout << buf << endl; //выводим код

    system("pause");
    return 0;
}