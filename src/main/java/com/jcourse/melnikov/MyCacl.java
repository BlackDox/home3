package com.jcourse.melnikov;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Created by BlackDox on 01.12.2017.
 */
public class MyCacl {
    public static void main(String[] args) {
        Calculator calc;

        if (args.length > 0){
            try {
                calc = new Calculator (new BufferedReader(new FileReader(args[0])));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
        } else {
            calc = new Calculator(new BufferedReader(new InputStreamReader(System.in)));
        }
        calc.start();

    }
}
