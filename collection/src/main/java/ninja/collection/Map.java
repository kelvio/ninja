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
public interface Map<K, V> {

    Set<K> keys();

    V get(K key);
        

    List<V> values();

    boolean containsKey(K key);
    
    /**
     *
     * @param <K>
     * @param <V>
     * @param key
     * @param value
     * @return
     */
    static <K, V> MapBuilder<K, V> of(Class<K> key, Class<V> value) {
        return new MapBuilder<>();
    }
    
    static <K, V> Map<K, V> of(Map<K, V> origin) {
        return new BirdHashMap<>(origin);
    }

    
    
    static class MapBuilder<K, V> {

        private java.util.Map<K, V> data = new HashMap<>();

        public MapBuilder<K, V> put(K key, V value) {
            data.put(key, value);
            return this;
        }

        public Map<K, V> build() {
            return new BirdHashMap<>(data);
        }

    }

}

class BirdHashMap<K, V> implements Map<K, V> {

    private final java.util.Map<K, V> data;

    private final Set<K> keySet;

    public BirdHashMap(Map<K, V> source) {
        this.data = new HashMap<>();
        source.keys().foreach(key -> {
            data.put(key, source.get(key));
        });        
        
        keySet = Set.of((K[]) data.keySet().toArray());
    }
    
    public BirdHashMap(java.util.Map<K, V> nativeMap) {
        this.data = new HashMap<>(nativeMap);
        
        keySet = Set.of((K[]) nativeMap.keySet().toArray());
    }

    @Override
    public Set<K> keys() {
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
    public V get(K key) {
        return data.get(key);
    }

}
