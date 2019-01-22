package by.zapolski.typeinfo;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types =
            new ArrayList<Class<? extends Pet>>();
    // Types that you want to be randomly created:
    private static String[] typeNames = {
            "by.zapolski.typeinfo.Mutt",
            "by.zapolski.typeinfo.Pug",
            "by.zapolski.typeinfo.EgyptianMau",
            "by.zapolski.typeinfo.Manx",
            "by.zapolski.typeinfo.Cymric",
            "by.zapolski.typeinfo.Rat",
            "by.zapolski.typeinfo.Mouse",
            "by.zapolski.typeinfo.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for(String name : typeNames)
                types.add(
                        (Class<? extends Pet>)Class.forName(name));
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static { loader(); }
    public List<Class<? extends Pet>> types() {return types;}
} ///:~}
