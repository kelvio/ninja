/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import ninja.consumer.BiConsumer;
import ninja.consumer.Consumer;

/**
 *
 * @author kelvio
 * @param <T>
 */
public interface List<T> extends Collection<T> {

    public static <T> List<T> of(T... args) {
        return arrayListOf(args);
    }
    
    public static <T> List<T> of(List<T> source) {
        return new BirdArrayList<>(source);
    }

    public static <T> List<T> linkedListOf(T... args) {
        return new BirdLinkedList<>(args);
    }

    public static <T> List<T> arrayListOf(T... args) {
        return new BirdArrayList<>(args);
    }
        
    
    T get(int index);

    void sort(Comparator<T> comparator);
    
    T[] toArray();
    
}

class BirdArrayList<T> implements List<T> {

    private final java.util.List<T> data;

    public BirdArrayList(List<T> source) {
        data = new ArrayList<>(source.size());
        source.foreach(item -> {
            data.add(item);
        });        
    }
    
    public BirdArrayList(T... args) {
        data = new ArrayList<>(args.length);
        data.addAll(Arrays.asList(args));
    }

    @Override
    public void foreach(Consumer<T> consumer) {
        data.stream().forEach((t) -> {
            consumer.consume(t);
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
    public void sort(Comparator<T> comparator) {
        Collections.sort(data, (T o1, T o2) -> comparator.compare(o1, o2));
    }

    @Override
    public Stream stream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T[] toArray() {
        return (T[]) data.toArray();
    }

    @Override
    public void foreach(BiConsumer<Integer, T> consumer) {
        for (int i = 0; i < data.size(); i++) {
            consumer.consume(i, data.get(i));
        }         
    }

    @Override
    public T get(int index) {
        return data.get(index);
    }
}

class BirdLinkedList<T> implements List<T> {

    private final java.util.List<T> data;

    public BirdLinkedList(T... args) {
        data = new java.util.LinkedList<>(Arrays.asList(args));
    }

    @Override
    public void foreach(Consumer<T> consumer) {
        data.stream().forEach((t) -> {
            consumer.consume(t);
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
    public void sort(Comparator<T> comparator) {
        Collections.sort(data, (T o1, T o2) -> comparator.compare(o1, o2));
    }

    @Override
    public Stream stream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public T[] toArray() {
        return (T[]) data.toArray();
    }
    
    @Override
    public void foreach(BiConsumer<Integer, T> consumer) {
        for (int i = 0; i < data.size(); i++) {
            consumer.consume(i, data.get(i));
        }         
    }
    
    @Override
    public T get(int index) {
        return data.get(index);
    }
}
