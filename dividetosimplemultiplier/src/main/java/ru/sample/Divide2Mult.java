package ru.sample;

import java.util.Scanner;

public class Divide2Mult {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое положительное число (n > 1):");
        int n = 0;
        try {
            n = sc.nextInt();
        } catch (Exception e){
            System.out.println("Ошибка, введено некорректное число");
        }
        sc.close();
        int i = 2;
        if (n > 1) System.out.println("Простые множители числа:");
        while(n > 1) {
            if (n % i == 0) {
                System.out.print(i + " ");
                n = n / i;
                --i;
            }
            i++;
        }
    }
}
