/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.collection;

import java.util.HashMap;

/**
 *
 * @author kelvio
 * @param <K>
 * @param <V>
 */
public interface MutableMap <K, V> extends Map<K, V> {    
    
    V put(K key, V value);
    
    public static <K, V> MutableMap<K, V> newEmptyMap() {
        return new BirdMutableHashMap<>(new HashMap<>());
    }
    
}


class BirdMutableHashMap<K, V> implements MutableMap<K, V> {

    private final java.util.Map<K, V> data;

    private Set<K> keySet;

    private boolean reloadKeys = false;
    
    public BirdMutableHashMap(java.util.Map<K, V> nativeMap) {
        this.data = new HashMap<>(nativeMap);
        reloadKeys = true;        
    }

    @Override
    public Set<K> keys() {
        if (reloadKeys || keySet == null) {
            keySet = Set.of((K[]) data.keySet().toArray());
            reloadKeys = false;
        }        
        return keySet;
    }

 

    @Override
    public List<V> values() {
        return List.arrayListOf((V[]) data.values().toArray());
    }

    @Override
    public boolean containsKey(K key) {
        return data.containsKey(key);
    }

    @Override
    public V put(K key, V value) {
        reloadKeys = true;
        return data.put(key, value);
    }
    
    @Override
    public V get(K key) {
        return data.get(key);
    }

}