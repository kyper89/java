package ru.kyper.java;

public class FirstAppHomeWork {
    
        // 1.
    public static void main(String[] args) {

            // 2.
        boolean bl1, bl2; // 1 bit
        bl1 = false;
        bl2 = true;
        System.out.println("boolean = " + bl1 + " : " + bl2);

        char c = 'c'; // 16 bits
        System.out.println("char = " + c);

        byte b1, b2; // 8 bits
        b1 = (byte) Math.pow(-2, 7);
        b2 = (byte) (Math.pow(-2, 7)- 1);
        System.out.println("byte = " + b1 + " : " + b2);

        short s1, s2; // 16 bits
        s1 = (short) Math.pow(-2, 15);
        s2 = (short) (Math.pow(-2, 15) - 1);
        System.out.println("short = " + s1 + " : " + s2);

        int i1, i2; // 32 bits
        i1 = (int) Math.pow(-2, 31);
        i2 = (int) (Math.pow(2, 31) - 1);
        System.out.println("int = " + i1 + " : " + i2);

        long l1, l2; // 64 bits
        l1 = (long) Math.pow(-2, 63);
        l2 = (long) (Math.pow(2, 63) - 1);
        System.out.println("long = " + l1 + " : " + l2);

        float f1, f2; // 32 bits
        f1 = -12345678f;
        f2 = 12345678f;
        System.out.println("float = " + f1 + " : " + f2);

        double d; // 64 bits
        d = 1e1d;
        System.out.println("double = " + d + " : " + d);

        String str = "Hello, World!";
        System.out.println(str);


            // 3.
        System.out.println("a * (b + (c / d)) = " + expression(1,3,4,2));

            // 4.
        System.out.println("сумма лежит в пределах от 10 до 20(включительно) = " + amountInRange(10,2));

            // 5.
        signOfNumber(0);

            // 6.
        System.out.println("число отрицательное = " + negativeNumber(-1));

            // 7.
        hello("Рома");

            // 8.
        leapYear(2000);
    }

        // 3.
    static int expression(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

        // 4.
    static boolean amountInRange(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

        // 5.
    static void signOfNumber(int a) {
        String sign = (a >= 0) ? "positive" : "negative";
        System.out.println("The sign of the transmitted number is " + sign);
    }

        // 6.
    static boolean negativeNumber(int a) {
        return a < 0;
    }

        // 7.
    static void hello(String name) {
        System.out.println("Привет, " + name + "!");
    }

        // 8.
    static void leapYear(int year) {
        boolean leap = year % 4 == 0 && (year % 400 == 0 || year % 100 != 0);
        System.out.println("Year " + year + " is" + ((leap) ? " " : " not ") + "a leap year.");
    }
}
