package by.zapolski.annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
    public static void trackuseCases (List<Integer> useCases, Class<?> cl){
        for (Method m: cl.getDeclaredMethods()){
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc!=null){
                System.out.println("Found Use Case: "+uc.id()+" "+uc.descrition());
                useCases.remove((Integer)uc.id());
            }
        }
        for(int i:useCases) System.out.println("Warning: Missing use case - "+i);
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases,47,48,49,50);
        trackuseCases(useCases,PasswordUtils.class);
    }
}
