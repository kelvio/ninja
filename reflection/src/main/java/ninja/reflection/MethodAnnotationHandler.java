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
public interface MethodAnnotationHandler <T extends Annotation> {
    
    public T withArgs(Class<?>[] types);

    public T withoutArgs();
    
}
