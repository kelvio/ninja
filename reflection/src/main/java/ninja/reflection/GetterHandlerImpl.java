/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.reflect.Field;

/**
 *
 * @author kelvio
 */
public class GetterHandlerImpl implements GetterHandler {

    private final net.vidageek.mirror.get.dsl.GetterHandler getterHandler;

    public GetterHandlerImpl(net.vidageek.mirror.get.dsl.GetterHandler getterHandler) {
        this.getterHandler = getterHandler;        
                
    }

    @Override
    public Object field(Field field) {
        return getterHandler.field(field);
    }

    @Override
    public Object field(String field) {
        return getterHandler.field(field);
    }
    
    
}
