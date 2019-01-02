package by.zapolski.annotations;

import by.zapolski.mindview.atunit.Test;

public class Testable {
    public void execute(){
        System.out.println("Executing..");
    }
    @Test
    void testExecute(){
        execute();
    }
}
