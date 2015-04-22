/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.reflect.Method;

/**
 *
 * @author kelvio
 */
public interface MethodReflector {
    
    public Method withoutArgs();

    public Method withArgs(Class<?>[] types);

    public Method withAnyArgs();
    
}
