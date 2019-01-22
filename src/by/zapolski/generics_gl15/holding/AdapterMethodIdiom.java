package by.zapolski.generics_gl15.holding;

import java.util.*;


class MultiIterableClass<T> extends ArrayList<T>{

    public MultiIterableClass(Collection<T> c) {
        super(c);
    }

    public Iterable<T> reversed(){
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size()-1;
                    @Override
                    public boolean hasNext() {
                        return current>-1;
                    }
                    @Override
                    public T next() {
                        return get(current--);
                    }
                };
            }
        };
    }

    public Iterable<T> randomize(){
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                List<T> shuffled = new ArrayList<T>(MultiIterableClass.this);
                Collections.shuffle(shuffled,new Random(48));
                return shuffled.iterator();
            }
        };
    }
}

public class AdapterMethodIdiom {

    public static void main(String[] args) {
        MultiIterableClass<String> ral = new MultiIterableClass<String>(Arrays.asList("To be or not to be".split(" ")));
        for (String s: ral) System.out.print(s+" ");
        System.out.println();

        for (String s: ral.reversed()) System.out.print(s+" ");
        System.out.println();

        for (String s: ral.randomize()) System.out.print(s+" ");
        System.out.println();
    }
}
