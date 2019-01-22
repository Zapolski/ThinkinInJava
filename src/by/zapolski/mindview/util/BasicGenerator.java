package by.zapolski.mindview.util;

import by.zapolski.util.Generator;

public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            //предполагается, что type открытый класс
            return type.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> create (Class<T> type){
        return new BasicGenerator<T>(type);
    }
}
