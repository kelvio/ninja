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
public interface ReflectionHandler <T> {

    public Field field(String string);

    public MethodReflector method(String string);

    public ConstructorReflector<T> constructor();

    public <A extends Object> AnnotationHandler<? extends A> annotation(Class<A> type);

    public ParameterizedElementHandler parentGenericType();

}
