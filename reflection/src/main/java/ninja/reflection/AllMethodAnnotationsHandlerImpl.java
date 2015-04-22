/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.annotation.Annotation;
import ninja.collection.List;
import ninja.collection.MutableList;

/**
 *
 * @author kelvio
 */
public class AllMethodAnnotationsHandlerImpl implements AllMethodAnnotationsHandler {

    private net.vidageek.mirror.reflect.dsl.AllMethodAnnotationsHandler handler;
    
    public AllMethodAnnotationsHandlerImpl(net.vidageek.mirror.reflect.dsl.AllMethodAnnotationsHandler handler) {
        this.handler = handler;
    }
    
    @Override
    public List<Annotation> withoutArgs() {
        MutableList<Annotation> l = MutableList.newEmptyList();
        java.util.List<Annotation> jl = handler.withoutArgs();
        jl.forEach(a -> {
            l.add(a);
        });
        return List.of(l);        
    }

    @Override
    public List<Annotation> withArgs(Class<?>[] types) {
        MutableList<Annotation> l = MutableList.newEmptyList();
        java.util.List<Annotation> jl = handler.withArgs(types);
        jl.forEach(a -> {
            l.add(a);
        });
        return List.of(l);
    }
    
}
