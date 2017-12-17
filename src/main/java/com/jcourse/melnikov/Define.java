package com.jcourse.melnikov;

import java.util.Map;
import java.util.Stack;

/**
 * Created by BlackDox on 08.12.2017.
 */
public class Define implements Command {
    @In(arg = ArgType.STACK)
    Stack<Double> stack;
    @In(arg = ArgType.DEFINITIONS)
    Map<String, Double> definitions;
    @In(arg = ArgType.CONTEXT)
    String[] line;

    @Override
    public void exec() {
        if (definitions.containsKey(line[1])){
            definitions.remove(line);
            System.out.println("Старое значение данной переменой утеряно!");
        }

        definitions.put(line[1], Double.valueOf(line[2]));
    }
}
