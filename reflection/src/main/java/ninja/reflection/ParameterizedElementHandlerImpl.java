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
public class ParameterizedElementHandlerImpl implements ParameterizedElementHandler {

    private net.vidageek.mirror.reflect.dsl.ParameterizedElementHandler parameterizedElementHandler;
    
    public ParameterizedElementHandlerImpl(net.vidageek.mirror.reflect.dsl.ParameterizedElementHandler parameterizedElementHandler) {
        this.parameterizedElementHandler = parameterizedElementHandler;
    }
    
    
    @Override
    public Class<?> atPosition(int i) {
        return parameterizedElementHandler.atPosition(i);
    }
    
}
