/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.reflect.Constructor;

/**
 *
 * @author kelvio
 */
public interface ConstructorReflector <T> {
    
    public Constructor<T> withArgs(Class<?>[] types);

    public Constructor<T> withoutArgs();

    public Constructor<T> withAnyArgs();
    
}
