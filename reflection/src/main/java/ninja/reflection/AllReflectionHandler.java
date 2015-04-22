/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import ninja.collection.List;

/**
 *
 * @author kelvio
 */
public interface AllReflectionHandler <T> {
    
    public List<Field> fields();

    public List<Method> methods();

    public List<Constructor<T>> constructors();

    public AllAnnotationsHandler annotations();

    public List<Method> setters();

    public List<Method> getters();
    
}
