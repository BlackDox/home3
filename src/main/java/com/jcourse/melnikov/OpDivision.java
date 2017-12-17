package com.jcourse.melnikov;

import java.util.Map;
import java.util.Stack;

/**
 * Created by BlackDox on 01.12.2017.
 */
public class OpDivision implements Command {
    @In(arg = ArgType.STACK)
    Stack<Double> stack;
    @In(arg = ArgType.DEFINITIONS)
    Map<String, Double> definitions;
    @In(arg = ArgType.CONTEXT)
    String[] line;

    @Override
    public void exec() {
        if (stack.size() >= 2){
            Double last = stack.pop();
            Double penultimate = stack.pop();
            stack.push(penultimate / last);
        } else {
            System.out.println("В стеке меньше двух элементов!");
        }
    }
}
