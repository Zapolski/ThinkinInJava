package by.zapolski.generics_gl15;

import by.zapolski.generics_gl15.coffee.Coffee;
import by.zapolski.generics_gl15.coffee.CoffeeGenerator;
import by.zapolski.generics_gl15.fibonacci.Fibonacci;
import by.zapolski.generics_gl15.util.Generator;

import java.util.ArrayList;
import java.util.Collection;

public class Generators {
    public static <T> Collection<T> fill (Collection<T> coll, Generator<T> gen, int n){
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }


    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(),4);
        coffee.forEach(System.out::println);

        Collection<Integer> fnumbers = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
        fnumbers.forEach(System.out::println);
    }


}
