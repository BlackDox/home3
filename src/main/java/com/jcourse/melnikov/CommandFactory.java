package com.jcourse.melnikov;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.Properties;

public class CommandFactory {
    private Properties props;

    public CommandFactory() {
        props = new Properties();
        try (InputStream in = CommandFactory.class.getResourceAsStream("p.properties")) {
            props.load(in);
//            System.out.println(props);
        } catch (IOException e) {
            System.out.println("чет не то...");
        }
    }
    public Command getCommand(String commandName, CalcContex ctx) {
        String property = props.getProperty(commandName);
        Command thisCommand = null;

        try {
            Class<?> aClass = Class.forName(property);
            Object o = aClass.newInstance();
            Field[] declaredFields = aClass.getDeclaredFields();
            thisCommand = (Command) o;

            for (Field declaredField : declaredFields) {
                In annotation = declaredField.getAnnotation(In.class);
                if (annotation != null) {
                    switch (annotation.arg()) {
                        case STACK:{
                            declaredField.set(o, ctx.getOperands());
                            break;
                        }
                        case DEFINITIONS:{
                            declaredField.set(o, ctx.getDefinitions());
                            break;
                        }
                        case CONTEXT:{
                            declaredField.set(o, ctx.getLine());
                            break;
                        }
                    }
                    /*if (ArgType.STACK == annotation.arg()) {
                        declaredField.set(o, operands);
                    }*/
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Класс не найден!");
        } catch (IllegalAccessException e) {
            System.out.println("Нет доступа!");
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return (Command) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{Command.class}, new ProxyLogger(thisCommand, ctx));
    }
}
