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
        Calculator calculatorMultiply = new Calculator();
        Calculator calculatorDivide = new Calculator();
        Calculator calculatorSumAll = new Calculator();
        System.out.println(calculatorSumAll.sumAllOperation(10));
        System.out.println(calculatorDivide.divide(5));
        System.out.println(Calculator.sum(10));
        System.out.println(Calculator.minus(10));
        System.out.println(calculatorMultiply.multiply(5));
    }
}