/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.collection;

/**
 *
 * @author kelvio
 * @param <T>
 */
public interface Stream <T> extends Iterable<T> {
    
    Stream<T> filter(Predicate <T> predicate);
    
    T first();
    
}
