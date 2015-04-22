/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.collection;

import ninja.consumer.Consumer;



/**
 *
 * @author kelvio
 * @param <T>
 */
public interface Stack <T> {
    
    public static <T> Stack<T> of(T ... items) {
        return null;
    }
    
    void foreach(Consumer<T> consumer);
    
}
