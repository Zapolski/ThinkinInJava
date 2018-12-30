package by.zapolski.generics_gl15.fibonacci;

public class Main {
    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.print(gen.next()+" ");
        }

        System.out.println();
        for (int i : new IterableFibonacci(18))
            System.out.print(i+" ");

        System.out.println();
        for (int i : new IterableFibonacciComp(18))
            System.out.print(i+" ");
    }

}
