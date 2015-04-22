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
class MethodReflectorImpl implements MethodReflector {

    private final net.vidageek.mirror.reflect.dsl.MethodReflector methodReflector;

    public MethodReflectorImpl(net.vidageek.mirror.reflect.dsl.MethodReflector methodReflector) {
        this.methodReflector = methodReflector;
    }
    
    @Override
    public Method withoutArgs() {
        return methodReflector.withoutArgs();
    }

    @Override
    public Method withArgs(Class<?>[] types) {
        return methodReflector.withArgs(types);
    }

    @Override
    public Method withAnyArgs() {
        return methodReflector.withAnyArgs();
    }
    
    
    
}
