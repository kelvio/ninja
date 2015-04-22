/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author kelvio
 * @param <T>
 */
public class InvocationHandlerImpl <T> implements InvocationHandler<T> {
    
    private final net.vidageek.mirror.invoke.dsl.InvocationHandler invocationHandler;

    public InvocationHandlerImpl(net.vidageek.mirror.invoke.dsl.InvocationHandler invocationHandler) {
        this.invocationHandler = invocationHandler;  
        
        
    }

    @Override
    public ConstructorHandler<T> constructor() {
        return new ConstructorHandlerImpl<>(invocationHandler.constructor());
    }

    @Override
    public ConstructorHandler<T> constructor(Constructor<T> constructor) {
        return new ConstructorHandlerImpl<>(invocationHandler.constructor(constructor));
    }

    @Override
    public Object getterFor(Field field) {
        return invocationHandler.getterFor(field);
    }

    @Override
    public Object getterFor(String field) {
        return invocationHandler.getterFor(field);
    }

    @Override
    public MethodHandler method(Method method) {
        return new MethodHandlerImpl(invocationHandler.method(method));
    }

    @Override
    public MethodHandler method(String method) {
        return new MethodHandlerImpl(invocationHandler.method(method));
    }

    @Override
    public SetterMethodHandler setterFor(String field) {
        return new SetterMethodHandlerImpl(invocationHandler.setterFor(field));
    }

    @Override
    public SetterMethodHandler setterFor(Field field) {
        return new SetterMethodHandlerImpl(invocationHandler.setterFor(field));
    }
    
}
