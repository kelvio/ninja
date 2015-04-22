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
 */
public interface InvocationHandler <T> {
    
    ConstructorHandler<T> constructor();
    
    ConstructorHandler<T> constructor(Constructor<T> constructor);
    
    Object getterFor(Field field);
    
    Object getterFor(String field);
    
    MethodHandler method(Method method);
    
    MethodHandler method(String method);
    
    SetterMethodHandler setterFor(String field);
    
    SetterMethodHandler setterFor(Field field);
}
