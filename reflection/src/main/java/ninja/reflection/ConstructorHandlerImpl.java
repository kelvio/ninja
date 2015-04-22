/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

/**
 *
 * @author kelvio
 */
class ConstructorHandlerImpl <T> implements ConstructorHandler<T> {

    private final net.vidageek.mirror.invoke.dsl.ConstructorHandler<T> constructorHandler;

    public ConstructorHandlerImpl(net.vidageek.mirror.invoke.dsl.ConstructorHandler<T> constructorHandler) {
        this.constructorHandler = constructorHandler;        
    }

    @Override
    public T bypasser() {
        return constructorHandler.bypasser();
    }

    @Override
    public T withArgs(Object... args) {
        return constructorHandler.withArgs(args);
    }

    @Override
    public T withoutArgs() {
        return constructorHandler.withoutArgs();
    }
    
    
    
}
