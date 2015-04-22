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
class FieldControllerImpl implements FieldController {
    
    private final net.vidageek.mirror.dsl.FieldController fieldController;

    public FieldControllerImpl(net.vidageek.mirror.dsl.FieldController fieldController) {
        this.fieldController = fieldController;
    }

    @Override
    public FieldHandler reflect() {
        return new FieldHandlerImpl(fieldController.reflect());
    }

    @Override
    public AllMemberHandler reflectAll() {
        return new AllMemberHandlerImpl(fieldController.reflectAll());
    }
    
}
