package com.jcourse.melnikov;

import java.io.*;

/**
 * Created by BlackDox on 01.12.2017.
 */
public class Calculator {
    BufferedReader reader;

    public Calculator(BufferedReader reader){
        this.reader = reader;
    }

    public void start(){
        System.out.println("Вводите команды. Для выхода нажмите ENTER при пустом поле:");
        String nextLine = null;
        CommandFactory factory = new CommandFactory();
        CalcContex ctx = new CalcContex();

        while (true) {
            try {
                nextLine = reader.readLine();

                    if (nextLine==null || nextLine.length()==0) {
                        break;
                    } else {
                        String args[] = nextLine.split(" ");
                        ctx.setLine(args);
                        Command command = factory.getCommand(args[0], ctx);
                        command.exec();
                    }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Программа успешно завершила работу!");
    }
}