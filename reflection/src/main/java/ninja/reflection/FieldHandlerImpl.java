/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.annotation.Annotation;

/**
 *
 * @author kelvio
 */
public class FieldHandlerImpl implements FieldHandler {
    
    private final net.vidageek.mirror.reflect.dsl.FieldHandler fieldHandler;

    public FieldHandlerImpl(net.vidageek.mirror.reflect.dsl.FieldHandler fieldHandler) {
        this.fieldHandler = fieldHandler;
    }

    @Override
    public <T extends Annotation> T annotation(Class<T> type) {
        return fieldHandler.annotation(type);
    }

    @Override
    public ParameterizedElementHandler genericType() {
        return new ParameterizedElementHandlerImpl(fieldHandler.genericType());
    }
    
    
    
}
