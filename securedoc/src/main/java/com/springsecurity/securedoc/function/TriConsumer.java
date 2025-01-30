package com.springsecurity.securedoc.function;

//
 /// 3/6/24
//

@FunctionalInterface
public interface TriConsumer<T, U, V> {
    void accept(T t, U u, V v);
}