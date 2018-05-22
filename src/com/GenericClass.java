package com;

public class GenericClass<T> {

    GenericClass<T> left, right;
    T data;

    public GenericClass(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
