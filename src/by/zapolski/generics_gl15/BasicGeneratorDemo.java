package by.zapolski.generics_gl15;

import by.zapolski.util.Generator;
import by.zapolski.mindview.util.BasicGenerator;

public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        Generator<CountedObject> gen2 = new BasicGenerator<CountedObject>(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }

        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen2.next());
        }
    }
}
