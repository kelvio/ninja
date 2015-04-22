/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.collection;

import ninja.consumer.BiConsumer;
import ninja.consumer.Consumer;

/**
 *
 * @author kelvio
 * @param <T>
 */
public interface Iterable <T> {
    
    void foreach(Consumer<T> consumer);
    
    void foreach(BiConsumer<Integer, T> consumer);
    
}
