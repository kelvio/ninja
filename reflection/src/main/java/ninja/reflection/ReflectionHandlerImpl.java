/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.reflect.Field;

/**
 *
 * @author kelvio
 */
public class ReflectionHandlerImpl <T> implements ReflectionHandler<T> {
    
    private net.vidageek.mirror.reflect.dsl.ReflectionHandler<T> reflectionHandler;
    
    public ReflectionHandlerImpl(net.vidageek.mirror.reflect.dsl.ReflectionHandler<T> reflectionHandler) {
        this.reflectionHandler = reflectionHandler;
    }

    @Override
    public Field field(String string) {
        return reflectionHandler.field(string);
    }

    @Override
    public MethodReflector method(String string) {
        return new MethodReflectorImpl(reflectionHandler.method(string));
    }

    @Override
    public ConstructorReflector<T> constructor() {
        return new ConstructorReflectorImpl<>(reflectionHandler.constructor());
    }

    @Override
    public <A> AnnotationHandler<? extends A> annotation(Class<A> type) {
        return new AnnotationHandlerImpl<>(reflectionHandler.annotation(type));
    }

    @Override
    public ParameterizedElementHandler parentGenericType() {
        return new ParameterizedElementHandlerImpl(reflectionHandler.parentGenericType());
    }
    
    
    
}
