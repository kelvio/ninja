/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.collection;

import java.util.Arrays;
import ninja.consumer.BiConsumer;
import ninja.consumer.Consumer;

/**
 *
 * @author kelvio
 * @param <T>
 */
public interface Set<T> extends Collection<T> {

    public static <T> Set<T> of(T... args) {
        return hashSetOf(args);
    }

    public static <T> Set<T> hashSetOf(T... args) {
        return new BirdHashSet<>(args);
    }

    public static <T> Set<T> treeSetOf(T... args) {
        return new BirdTreeSet<>(args);
    }
    
}

class BirdHashSet<T> implements Set<T> {

    private final java.util.HashSet<T> data;

    public BirdHashSet(T... args) {
        data = new java.util.HashSet<>(args.length);
        for (T t : args) {
            data.add(t);
        }
    }

    @Override
    public void foreach(Consumer<T> consumer) {
        data.forEach(i -> {
            consumer.consume(i);
        });
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public Stream stream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void foreach(BiConsumer<Integer, T> consumer) {        
        CounterHolder h = new CounterHolder();
        data.forEach(value -> {            
            consumer.consume(h.i, value);
            h.i++;
        });        
    }
    
    private class CounterHolder {
        int i = 0;
    }

}

class BirdTreeSet<T> implements Set<T> {

    private final java.util.TreeSet<T> data;

    public BirdTreeSet(T... args) {
        data = new java.util.TreeSet<>(Arrays.asList(args));
    }

    @Override
    public void foreach(Consumer<T> consumer) {
        data.forEach(i -> {
            consumer.consume(i);
        });
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public Stream stream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void foreach(BiConsumer<Integer, T> consumer) {        
        CounterHolder h = new CounterHolder();
        data.forEach(value -> {            
            consumer.consume(h.i, value);
            h.i++;
        });        
    }
    
    private class CounterHolder {
        int i = 0;
    }
}
