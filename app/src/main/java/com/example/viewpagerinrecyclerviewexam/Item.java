package com.example.viewpagerinrecyclerviewexam;

public class Item<T> {
    private T item;

    public Item(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
