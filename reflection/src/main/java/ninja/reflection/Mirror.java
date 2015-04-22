/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

/**
 *
 * @author kelvio
 */
public interface Mirror {
    
    public static Class<?> reflectClass(String name) {        
        return new net.vidageek.mirror.dsl.Mirror().reflectClass(name);
        
    }
    
    public static MemberController on(AnnotatedElement element) {
        return new MemberControllerImpl(new net.vidageek.mirror.dsl.Mirror().on(element));
    }
    
    public static <T> ClassController<T> on(Class<T> clazz) {
        return new ClassControllerImpl<>(new net.vidageek.mirror.dsl.Mirror().on(clazz));
    }
    
    public static FieldController on(Field field) {
        return new FieldControllerImpl(new net.vidageek.mirror.dsl.Mirror().on(field));
    }
    
    public static AccessorsController on(Object object) {
        return new AccessorsControllerImpl(new net.vidageek.mirror.dsl.Mirror().on(object));
    }
    
    public static ClassController<?> on(String className) {
        return new ClassControllerImpl<>(new net.vidageek.mirror.dsl.Mirror().on(Mirror.reflectClass(className)));
    }
    
}
