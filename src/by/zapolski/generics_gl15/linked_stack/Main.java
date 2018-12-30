package by.zapolski.generics_gl15.linked_stack;

import by.zapolski.generics_gl15.linked_stack.LinkedStack_task;

public class Main {
    public static void main(String[] args) {


        LinkedStack_task<String> lss = new LinkedStack_task<String>();
        for (String s: "Phasers on stun!".split(" "))
            lss.push(s);
        String s;
        while ((s=lss.pop()) != null)
            System.out.println(s);


    }

}
