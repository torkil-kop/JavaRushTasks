package com.javarush.task.task33.task3310.strategy;

import java.util.Arrays;

public class OurHashMapStorageStrategy implements StorageStrategy{
     static final int DEFAULT_INITIAL_CAPACITY = 16;
     static final float DEFAULT_LOAD_FACTOR = 0.75f;
     Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
     int size;
     int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
     float loadFactor = DEFAULT_LOAD_FACTOR;

    public int hash(Long k){
        int h;
        return  k.hashCode();
    }
    public int indexFor(int hash, int length){
        return (length - 1) & hash;
    }

    final Entry getEntry(Long key) {
        if (size == 0) {
            return null;
        }
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        for (Entry entry = table[index]; entry != null; entry = entry.next) {
            if (key.equals(entry.key)) {
                return entry;
            }
        }
        return null;
    }
    void resize(int newCapacity) {
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }

    void transfer(Entry[] newTable) {
        int newCapacity = newTable.length;
        for (Entry e : table) {
            while (e != null) {
                Entry next = e.next;
                int indexInNewTable = indexFor(hash(e.getKey()), newCapacity);
                e.next = newTable[indexInNewTable];
                newTable[indexInNewTable] = e;
                e = next;
            }
        }
    }
    public void addEntry(int hash, Long key, String value, int bucketIndex){
        Entry tab[] = table;
        if (size >= threshold) {
            resize(table.length*2);
            tab = table;
            hash = key.hashCode();
            bucketIndex = indexFor(hash, table.length);
        }

      createEntry(hash, key, value, bucketIndex);


           }
           public void createEntry(int hash, Long key, String value, int bucketIndex){
               Entry e = table[bucketIndex];
              table[bucketIndex] = new Entry(hash, key, value, e);
               size++;
           }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        for (Entry tableElement : table)
            for (Entry e = tableElement; e != null; e = e.next)
                if (value.equals(e.value))
                    return true;
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        for (Entry e = table[index]; e != null; e = e.next) {
            if (key.equals(e.key)) {
                e.value = value;
                return;
            }
        }
        addEntry(hash, key, value, index);
    }

    @Override
    public Long getKey(String value) {
        for (Entry tableElement : table)
            for (Entry e = tableElement; e != null; e = e.next)
                if (value.equals(e.value))
                    return e.getKey();
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry entry = getEntry(key);
        if (entry != null)
            return entry.getValue();

        return null;
    }
}
/*
8.2. Реализуй в классе следующие вспомогательные методы:
8.2.1. int hash(Long k)
8.2.2. int indexFor(int hash, int length)
8.2.3. Entry getEntry(Long key)
8.2.4. void resize(int newCapacity)
8.2.5. void transfer(Entry[] newTable)
8.2.6. void addEntry(int hash, Long key, String value, int bucketIndex)
8.2.7. void createEntry(int hash, Long key, String value, int bucketIndex)
 */