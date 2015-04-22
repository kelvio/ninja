/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.collection;

/**
 *
 * @author kelvio
 */
public interface MutableSet<T> extends Set<T> {
    
    public static <T> MutableSet<T> of(T ... args) {
        return null;
    }
    
    public static <T> MutableSet<T> hash_set_of(T ... args) {
        return null;
    }
    
    public static <T> MutableSet<T> tree_set_of(T ... args) {
        return null;
    }
    
}
