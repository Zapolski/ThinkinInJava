package by.zapolski.exeptions;

class NeddsCleanup{
    private static long counter = 1;
    private final long id = counter++;
    public void dispose(){
        System.out.println("NeedsCleanup"+id+" free.");
    }
}

class ConstructionException extends Exception{}

class NeedsCleanup2 extends NeddsCleanup{
    public NeedsCleanup2()  throws ConstructionException{}
}

public class CleanupIdiom {
    public static void main(String[] args) {
        NeddsCleanup nc1 = new NeddsCleanup();
        try {
        }finally {
            nc1.dispose();
        }

        NeddsCleanup nc2 = new NeddsCleanup();
        NeddsCleanup nc3 = new NeddsCleanup();
        try{

        }finally {
            nc3.dispose();
            nc2.dispose();
        }

        try{
            NeedsCleanup2 nc4 = new NeedsCleanup2();
            try {
                NeedsCleanup2 nc5 = new NeedsCleanup2();
                try{

                }finally {
                    nc5.dispose();
                }
            }catch (ConstructionException e){//constructor nc5
                System.out.println(e);
            }finally {
                nc4.dispose();
            }
        }catch (ConstructionException e){//constructor nc4
            System.out.println(e);
        }

    }
}
