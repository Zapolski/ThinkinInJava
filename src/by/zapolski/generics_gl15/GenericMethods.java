package by.zapolski.generics_gl15;

public class GenericMethods {
    public <T,A,B> void f(T x,A a,B b){
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("",null,null);
        gm.f(1,null,null);
        gm.f(1.0,null,null);
        gm.f(1.0f,null,null);
        gm.f('c',null,null);
        gm.f(gm,null,null);

    }
}
