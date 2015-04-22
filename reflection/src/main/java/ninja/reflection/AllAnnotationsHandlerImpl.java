/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 *
 * @author kelvio
 */
public class AllAnnotationsHandlerImpl implements AllAnnotationsHandler {
    
    private final net.vidageek.mirror.reflect.dsl.AllAnnotationsHandler allAnnotationsHandler;
    
    public AllAnnotationsHandlerImpl(net.vidageek.mirror.reflect.dsl.AllAnnotationsHandler allAnnotationsHandler) {
        this.allAnnotationsHandler = allAnnotationsHandler;
    }

    @Override
    public List<Annotation> atClass() {
        return allAnnotationsHandler.atClass();
    }

    @Override
    public List<Annotation> atField(String string) {
        return allAnnotationsHandler.atField(string);
    }

    @Override
    public AllMethodAnnotationsHandler atMethod(String string) {
        return new AllMethodAnnotationsHandlerImpl(allAnnotationsHandler.atMethod(string));
    }
    
    
}
