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
class ClassControllerImpl<T> implements ClassController<T> {
    
    private final net.vidageek.mirror.dsl.ClassController<T> classController;

    public ClassControllerImpl(net.vidageek.mirror.dsl.ClassController<T> classController) {
        this.classController = classController;        
    }

    @Override
    public ReflectionHandler<T> reflect() {
        return new ReflectionHandlerImpl<>(classController.reflect());
    }

    @Override
    public AllReflectionHandler<T> reflectAll() {
        
        return new AllReflectionHandlerImpl<>(classController.reflectAll());
    }
    
}
