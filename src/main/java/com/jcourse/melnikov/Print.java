package com.jcourse.melnikov;

import java.util.Map;
import java.util.Stack;

/**
 * Created by BlackDox on 08.12.2017.
 */
public class Print implements Command {
    @In(arg = ArgType.STACK)
    Stack<Double> stack;
    @In(arg = ArgType.DEFINITIONS)
    Map<String, Double> definitions;
    @In(arg = ArgType.CONTEXT)
    String[] line;

    @Override
    public void exec() {
        if (!stack.empty()){
            System.out.println(stack.peek());
            System.out.println("Весь стек: "+ stack);
        } else {
            System.out.println("Стек пуст!");
        }
    }
}
