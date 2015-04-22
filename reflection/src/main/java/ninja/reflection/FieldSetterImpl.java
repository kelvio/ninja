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
class FieldSetterImpl implements FieldSetter {
    
    private final net.vidageek.mirror.set.dsl.FieldSetter fieldSetter;

    public FieldSetterImpl(net.vidageek.mirror.set.dsl.FieldSetter fieldSetter) {
        this.fieldSetter = fieldSetter;        
    }

    @Override
    public void withValue(Object value) {
        fieldSetter.withValue(value);
    }
    
    
    
    
}
