/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.annotation.Annotation;

/**
 *
 * @author kelvio
 * @param <T>
 */
public class MethodAnnotationHandlerImpl <T extends Annotation> implements MethodAnnotationHandler<T> {

    private final net.vidageek.mirror.reflect.dsl.MethodAnnotationHandler<T> methodAnnotationHandler;

    public MethodAnnotationHandlerImpl(net.vidageek.mirror.reflect.dsl.MethodAnnotationHandler<T> methodAnnotationHandler) {
        this.methodAnnotationHandler = methodAnnotationHandler;
    }
    
    
    
    @Override
    public T withArgs(Class<?>[] types) {
        return methodAnnotationHandler.withArgs(types);
    }

    @Override
    public T withoutArgs() {
        return methodAnnotationHandler.withoutArgs();
    }
    
}
