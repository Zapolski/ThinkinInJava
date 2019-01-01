package by.zapolski.tasks;

public class page530 {
    public static void main(String[] args) {
        new AnotherClass().anotherMethod(new ClassImplInter());
    }
}

interface Interf{
    void m1();
    void m2();
}

class ClassImplInter implements Interf{
    @Override
    public void m1() {
        System.out.println("m1");
    }

    @Override
    public void m2() {
        System.out.println("m2");

    }

    public void m3(){
        System.out.println("m3");
    }
}

class AnotherClass{
    public <T extends Interf> void  anotherMethod (T par){
        par.m1();
        par.m2();
    }
}
