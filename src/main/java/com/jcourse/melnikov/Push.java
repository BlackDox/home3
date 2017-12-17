package com.jcourse.melnikov;

import java.util.Map;
import java.util.Stack;

/**
 * Created by BlackDox on 08.12.2017.
 */
public class Push implements Command {
    @In(arg = ArgType.STACK)
    Stack<Double> stack;
    @In(arg = ArgType.DEFINITIONS)
    Map<String, Double> definitions;
    @In(arg = ArgType.CONTEXT)
    String[] line;

    @Override
    public void exec() {
        if (definitions.containsKey(line[1])) {
            stack.push(definitions.get(line[1]));
        } else {
            System.out.println("Такая переменная не задана!");
        }
    }
}
