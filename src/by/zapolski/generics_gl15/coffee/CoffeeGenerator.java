package by.zapolski.generics_gl15.coffee;

import by.zapolski.generics_gl15.util.Generator;

import java.util.Iterator;
import java.util.Random;
import java.util.Spliterator;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class,Mocha.class,Cappuccino.class,Americano.class,Breve.class};
    private static Random rand = new Random(47);

    public CoffeeGenerator() {
    }

    //для перебора
    private int size = 0;
    public CoffeeGenerator(int sz){
        size=sz;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee)types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee>{
        int count = size;
        @Override
        public boolean hasNext() {
            return count>0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    @Override
    public Spliterator<Coffee> spliterator() {
        return null;
    }
}
