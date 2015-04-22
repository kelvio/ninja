/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.annotation.Annotation;
import net.vidageek.mirror.reflect.dsl.MethodAnnotationHandler;

/**
 *
 * @author kelvio
 * @param <T>
 */
public class AnnotationHandlerImpl <T extends Annotation> implements AnnotationHandler<T> {

    private final net.vidageek.mirror.reflect.dsl.AnnotationHandler<T> annotationHandler;
    
    public AnnotationHandlerImpl(net.vidageek.mirror.reflect.dsl.AnnotationHandler<T> annotationHandler) {
        this.annotationHandler = annotationHandler;
    }
    
    @Override
    public T atField(String string) {
        return annotationHandler.atField(string);
    }

    @Override
    public MethodAnnotationHandler<T> atMethod(String string) {
        return annotationHandler.atMethod(string);
    }

    @Override
    public T atClass() {
        return annotationHandler.atClass();
    }
    
    
    
}
