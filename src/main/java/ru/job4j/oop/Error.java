package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void show() {
        System.out.println("active: " + active);
        System.out.println("status: " + status);
        System.out.println("message: " + message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.show();
        Error errorNew = new Error(true, 1, "new error");
        errorNew.show();
        Error errorWarning = new Error(true, 2, "warning");
        errorWarning.show();
        Error errorInfo = new Error(false, 3, "info");
        errorInfo.show();
    }
}
