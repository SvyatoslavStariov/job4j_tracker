package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int divide(int number) {
        return number / x;
    }

    public static int minus(int number) {
        return number - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperation(int number) {
        return sum(number) + divide(number)
                + minus(number) + minus(number);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.sumAllOperation(10));
        System.out.println(calculator.divide(5));
        System.out.println(Calculator.sum(10));
        System.out.println(Calculator.minus(10));
        System.out.println(calculator.multiply(5));
    }
}