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
class SetterMethodHandlerImpl implements SetterMethodHandler {
    
    private final net.vidageek.mirror.invoke.dsl.SetterMethodHandler setterMethodHandler;

    public SetterMethodHandlerImpl(net.vidageek.mirror.invoke.dsl.SetterMethodHandler setterMethodHandler) {
        this.setterMethodHandler = setterMethodHandler;        
    }

    @Override
    public void withValue(Object value) {
        setterMethodHandler.withValue(value);
    }
    
    
}
