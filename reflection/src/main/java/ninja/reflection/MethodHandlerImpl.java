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
class MethodHandlerImpl implements MethodHandler {
    
    private final net.vidageek.mirror.invoke.dsl.MethodHandler methodHandler;

    public MethodHandlerImpl(net.vidageek.mirror.invoke.dsl.MethodHandler methodHandler) {
        this.methodHandler = methodHandler;        
    }

    @Override
    public Object withoutArgs() {
        return methodHandler.withoutArgs();
    }

    @Override
    public Object withArgs(Object... args) {
        return methodHandler.withArgs(args);
    }
    
}
