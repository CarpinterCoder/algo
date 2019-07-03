package com.company.algo.myLeetcode.linked;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 17:22 2018/8/1
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V>{
    private int maxSize;

    LRUCache(int maxSize){
        super(maxSize,0.75f,true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size()>maxSize;
    }

    public V set(K key,V value){
        return put(key,value);
    }


    public V get(Object key){
        return super.get(key);
    }
}
