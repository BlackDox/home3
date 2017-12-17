package com.jcourse.melnikov;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CalcContex {
    private Stack<Double> operands = new Stack<>();
    private Map<String, Double> definitions = new HashMap<>();
    private String[] line;

    public void setLine(String[] line) {
        this.line = line;
    }

    public Stack<Double> getOperands() {
        return operands;
    }

    public Map<String, Double> getDefinitions() {
        return definitions;
    }

    public String[] getLine() {
        return line;
    }
}
