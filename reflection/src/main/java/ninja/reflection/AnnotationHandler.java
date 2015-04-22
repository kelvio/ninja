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
public interface AnnotationHandler <T extends Annotation> {
    
    public T atField(String string);

    public MethodAnnotationHandler<T> atMethod(String string);

    public T atClass();
    
}
