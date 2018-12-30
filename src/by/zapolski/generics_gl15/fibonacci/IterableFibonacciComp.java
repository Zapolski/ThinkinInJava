package by.zapolski.generics_gl15.fibonacci;

import java.util.Iterator;

//адаптер с использованием композии
public class IterableFibonacciComp implements Iterable<Integer> {
    private int n;
    private Fibonacci fib;

    public IterableFibonacciComp(int n) {
        this.n = n;
        this.fib = new Fibonacci();
    }

    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n>0;
            }

            @Override
            public Integer next() {
                n--;
                return fib.next();
            }
        };
    }
}
