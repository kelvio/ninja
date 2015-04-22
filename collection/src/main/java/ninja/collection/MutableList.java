/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.collection;

import java.util.Arrays;
import java.util.Collections;
import ninja.consumer.BiConsumer;
import ninja.consumer.Consumer;

/**
 *
 * @author kelvio
 * @param <T>
 */
public interface MutableList <T> extends List<T> {
    
    MutableList<T> add(T ... items);
    
    MutableList<T> remove(T ... items);
    
    public static <T> MutableList<T> of(T ... args) {
        return arrayListOf(args);
    }
    
    public static <T> MutableList<T> newEmptyList() {
        return arrayListOf();
    }
    
    public static <T> MutableList<T> linkedListOf(T ... args) {
        return new BirdMutableLinkedList<>(args);
    }
    
    public static <T> MutableList<T> arrayListOf(T ... args) {
        return new BirdMutableArrayList<>(args);
    }
    
}

class BirdMutableLinkedList<T> implements MutableList<T> {

    private final java.util.List<T> data;

    public BirdMutableLinkedList(T... args) {
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
    public MutableList<T> add(T... items) {
        data.addAll(Arrays.asList(items));
        return this;
    }

    @Override
    public MutableList<T> remove(T... items) {
        for (T item : items) {
            data.remove(item);
        }
        return this;
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

class BirdMutableArrayList<T> implements MutableList<T> {

    private final java.util.List<T> data;

    public BirdMutableArrayList(T... args) {
        data = new java.util.ArrayList<>(Arrays.asList(args));
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
    public MutableList<T> add(T... items) {
        for (T item : items) {
            data.add(item);
        }
        return this;
    }

    @Override
    public MutableList<T> remove(T... items) {
        for (T item : items) {
            data.remove(item);
        }
        return this;
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