package com.jcourse.melnikov;

import org.apache.log4j.Logger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyLogger implements InvocationHandler {
    private static final Logger LOGGER = Logger.getLogger(CommandFactory.class); //
    private CalcContex ctx;
    private Command command;

    public ProxyLogger(Command command, CalcContex ctx){
        this.ctx = ctx;
        this.command = command;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (ctx.getOperands().empty()) {
            LOGGER.debug("Stack before: Stack null");
        } else {
            LOGGER.debug("Stack before: " + ctx.getOperands().peek());
        }

        Object result =  method.invoke(command, args);

        LOGGER.debug(ctx.getDefinitions());

        if (ctx.getOperands().empty()) {
            LOGGER.debug("Stack after: Stack null");
        } else {
            LOGGER.debug("Stack after: " + ctx.getOperands().peek());
        }

        return result;
    }
}
