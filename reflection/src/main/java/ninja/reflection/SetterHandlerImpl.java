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
public class SetterHandlerImpl implements SetterHandler {

    private final net.vidageek.mirror.set.dsl.SetterHandler setterHandler;

    public SetterHandlerImpl(net.vidageek.mirror.set.dsl.SetterHandler setterHandler) {
        this.setterHandler = setterHandler;
    }

    @Override
    public FieldSetter field(Field field) {
        return new FieldSetterImpl(setterHandler.field(field));
    }

    @Override
    public FieldSetter field(String field) {
        return new FieldSetterImpl(setterHandler.field(field));
    }

}
