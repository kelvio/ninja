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
class ConstructorReflectorImpl<T> implements ConstructorReflector<T> {
    
    private net.vidageek.mirror.reflect.dsl.ConstructorReflector<T> constructorReflector;

    public ConstructorReflectorImpl(net.vidageek.mirror.reflect.dsl.ConstructorReflector<T> constructorReflector) {
        this.constructorReflector = constructorReflector;
    }
    
    @Override
    public Constructor<T> withArgs(Class<?>[] types) {
        return constructorReflector.withArgs(types);
    }

    @Override
    public Constructor<T> withoutArgs() {
        return constructorReflector.withoutArgs();
    }

    @Override
    public Constructor<T> withAnyArgs() {
        return constructorReflector.withAnyArgs();
    }
    
    
    
    
}
