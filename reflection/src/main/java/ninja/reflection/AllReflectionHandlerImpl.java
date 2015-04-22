/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.vidageek.mirror.list.dsl.MirrorList;
import ninja.collection.List;
import ninja.collection.MutableList;

/**
 *
 * @author kelvio
 */
public class AllReflectionHandlerImpl <T> implements AllReflectionHandler<T> {
    
    private net.vidageek.mirror.reflect.dsl.AllReflectionHandler<T> allReflectionHandler;
    
    
    public AllReflectionHandlerImpl(net.vidageek.mirror.reflect.dsl.AllReflectionHandler<T> allReflectionHandler) {
        this.allReflectionHandler = allReflectionHandler;
    }

    @Override
    public List<Field> fields() {
        MutableList<Field> l = MutableList.newEmptyList();
        MirrorList ml = allReflectionHandler.fields();
        ml.stream().forEach((o) -> {
            l.add((Field) o);
        });
        return List.of(l);
    }

    @Override
    public List<Method> methods() {
        MutableList<Method> l = MutableList.newEmptyList();
        MirrorList ml = allReflectionHandler.methods();
        ml.stream().forEach((o) -> {
            l.add((Method) o);
        });
        return List.of(l);
    }

    @Override
    public List<Constructor<T>> constructors() {
        MutableList<Constructor<T>> l = MutableList.newEmptyList();
        MirrorList ml = allReflectionHandler.constructors();
        ml.stream().forEach((o) -> {
            l.add((Constructor<T>) o);
        });
        return List.of(l);
    }

    @Override
    public AllAnnotationsHandler annotations() {
        return new AllAnnotationsHandlerImpl(allReflectionHandler.annotations());
    }

    @Override
    public List<Method> setters() {
        MutableList<Method> l = MutableList.newEmptyList();
        MirrorList ml = allReflectionHandler.setters();
        ml.stream().forEach((o) -> {
            l.add((Method) o);
        });
        return List.of(l);
    }

    @Override
    public List<Method> getters() {
        MutableList<Method> l = MutableList.newEmptyList();
        MirrorList ml = allReflectionHandler.getters();
        ml.stream().forEach((o) -> {
            l.add((Method) o);
        });
        return List.of(l);
    }
    
}
