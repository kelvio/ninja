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
class AccessorsControllerImpl implements AccessorsController {
    
    private final net.vidageek.mirror.dsl.AccessorsController accessorsController;

    public AccessorsControllerImpl(net.vidageek.mirror.dsl.AccessorsController accessorsController) {
        this.accessorsController = accessorsController;        
    }

    @Override
    public GetterHandler get() {
        return new GetterHandlerImpl(accessorsController.get());
    }

    @Override
    public SetterHandler set() {
        return new SetterHandlerImpl(accessorsController.set());
    }

    @Override
    public InvocationHandler<Object> invoke() {
        return new InvocationHandlerImpl<>(accessorsController.invoke());
    }
    
}
