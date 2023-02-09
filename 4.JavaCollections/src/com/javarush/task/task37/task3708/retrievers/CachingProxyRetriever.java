package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{

    LRUCache<Long, Object> lruCache = new LRUCache<>(20);
    OriginalRetriever originalRetriever;

    public CachingProxyRetriever(Storage storage) {
        this.originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object o;
        if ( (o = lruCache.find(id)) != null){
            return o;
        }
        o = originalRetriever.retrieve(id);
        lruCache.set(id, o);
        return o;
    }
}
/*
Requirements:
1. В классе CachingProxyRetriever должно быть создано поле типа OriginalRetriever.
2. В классе CachingProxyRetriever должно быть создано поле типа LRUCache.
3. Конструктор класса CachingProxyRetriever должен принимать один параметр типа Storage и инициализировать поле типа OriginalRetriever.
4. Метод retrieve класса CachingProxyRetriever должен выполнять поиск подходящего объекта в кеше с помощью метода find.
5. Метод retrieve класса CachingProxyRetriever должен получать объект из хранилища с помощью метода retrieve объекта типа OriginalRetriever и добавлять в кеш, если он не был там найден.
6. Метод retrieve класса CachingProxyRetriever не должен вызывать метод retrieve класса OriginalRetriever, если объект был найден в кеше.
7. Метод retrieve класса CachingProxyRetriever должен возвращать объект, которому в хранилище соответствует id, полученный в качестве параметра.
8. Класс CachingProxyRetriever должен поддерживать интерфейс Retriever.
 */