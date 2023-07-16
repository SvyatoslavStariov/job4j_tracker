package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[]{
                new Book("one", 12),
                new Book("two", 232),
                new Book("three", 234),
                new Book("clean code", 234)
        };
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getPage());
        }
        Book bookTemp = books[3];
        books[3] = books[0];
        books[0] = bookTemp;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getPage());
        }
        for (Book book : books) {
            if ("clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getPage());
            }
        }
    }
}
