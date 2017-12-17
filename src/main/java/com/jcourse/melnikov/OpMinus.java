package com.jcourse.melnikov;

import java.util.Map;
import java.util.Stack;

/**
 * Created by BlackDox on 01.12.2017.
 */
public class OpMinus implements Command {
    @In(arg = ArgType.STACK)
    Stack<Double> stack;
    @In(arg = ArgType.DEFINITIONS)
    Map<String, Double> definitions;
    @In(arg = ArgType.CONTEXT)
    String[] line;

    @Override
    public void exec() {
        if (stack.size() >= 2){
            stack.push(- stack.pop() + stack.pop());
        } else if (stack.size() == 1){
            stack.push(0.0 - stack.pop());
        } else {
            System.out.println("Стек пуст!");
        }
    }
}
