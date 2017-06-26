package ru.sample;


import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fibonacchi {

    private static long[] f = new long[300];

    private static long recurcefib(int n){
//        if ((n == 0) || (n == 1)) return 1;
        if (n == 0 ) return 0;
        if (n == 1 ) return 1;
        return recurcefib(n-1) + recurcefib(n-2);
    }

    public static long recurcememfib(int n) {
//        if ((n == 0) || (n == 1)) return 1;
        if (n == 0 ) return 0;
        if (n == 1 ) return 1;
        if (f[n] == 0) f[n] = recurcememfib(n-1) + recurcememfib(n-2);
        return f[n];
    }

    public static int getInt()
    {
        Scanner in = new Scanner(System.in);
        String s;
        Pattern p = Pattern.compile("\\d+$");
        Matcher m;

        do
        {
            System.out.println("Введите целое число (должно быть целым и больше или равно 0):");
            s = in.nextLine();
            m = p.matcher(s);
        } while(!m.matches());

        in.close();

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {

        int n = getInt();

        if ((n == 0) || (n == 1)) {
            System.out.println("Для чисел под номером 0 и 1 значение 0");
            System.exit(0);
        }
        long[] f = new long[n];

        Arrays.fill(f,0);
        f[1] = 1L;

        System.out.println("====== Вывод чисел Фибоначчи с помощью рекурсии без запоминания значений ======");

        long start1 = System.currentTimeMillis();

        System.out.println();
        System.out.print("Ряд =");

        for (int i = 0; i < n; i++) {

            System.out.print(" " + Fibonacchi.recurcefib(i));
        }

        float time1 = (float)(System.currentTimeMillis() - start1)/1000;

        System.out.println();
        System.out.print("Затрачено времени = " + time1 + " сек");

        System.out.println();
        System.out.println();
        System.out.println("====== Вывод чисел Фибоначчи с помощью рекурсии с запоминанием значений ======");

        long start2 = System.currentTimeMillis();

        System.out.println();
        System.out.print("Ряд =");

        for (int i = 0; i < n; i++) {

            System.out.print(" " + Fibonacchi.recurcememfib(i));
        }

        float time2 = (float)(System.currentTimeMillis() - start2)/1000;

        System.out.println();
        System.out.print("Затрачено времени = " + time2 + " сек");
    }
}
