package pl.todrzywolek.springtask.model;

public class Fibonacci {

    private int number;
    private boolean isFibonacci;

    public Fibonacci() {
        this.number = -1;
        this.isFibonacci = false;
    }

    public Fibonacci(int number) {
        this.number = number;
        this.isFibonacci = checkFibonacci(number);
    }

    public int getNumber() {
        return number;
    }

    public boolean getIsFibonacci() {
        return isFibonacci;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setFibonacci(boolean fibonacci) {
        isFibonacci = fibonacci;
    }

    // A helper method that returns true if x is perfect square

    private boolean isPerfectSquare(int num) {
        int square = (int) Math.sqrt(num);

        return (square * square == num);
    }

    // Returns true if num is a Fibonacci Number, else false
    private boolean checkFibonacci(int num) {
        if (num < 0)
            return false;

        int square1 = 5*num*num + 4;
        int square2 = 5*num*num - 4;

        return isPerfectSquare(square1) || isPerfectSquare(square2);
    }
}
