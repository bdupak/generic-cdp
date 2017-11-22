package com.epam.logic.container.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class GenericHolder<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int capacity = 0;
    private int size = 0;
    private Object[] holder;

    public GenericHolder() {
        initHolder(DEFAULT_CAPACITY);
    }

    public GenericHolder(int capacity) {
        initHolder(capacity);
    }

    private void initHolder(int capacity) {
        if (capacity >= 0) {
            holder = new Object[capacity];
            this.capacity = capacity;
        } else {
            throw new NegativeArraySizeException("The size of container can't be negative");
        }
    }

    public void addElement(T element) {
        if (size == capacity)
            resize();
        holder[size] = element;
        size++;
    }

    public void resize() {
        capacity = capacity + (capacity >> 1);
        holder = Arrays.copyOf(holder, capacity);
    }

    public Object getElement(int index) {
        if (index < size && index >= 0) {
            return holder[index];
        } else if (index > size) {
            throw new IndexOutOfBoundsException(String.format("The holder has %s elements but not %s", size, index));
        } else if (index < 0) {
            throw new IndexOutOfBoundsException("You can use negative index");
        }
        throw new IllegalArgumentException("Oops something goes wrong");
    }

    public boolean findElement(T element) {
        for (Object entity : holder) {
            if (entity.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int getIndex(T element) {
        for (int i = 0; i < size; i++) {
            if (holder[i].equals(element)) {
                return i;
            }
        }
        throw new IllegalArgumentException("No such element in container");
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator<>();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        T[] elements = (T[]) holder;
        for (int i = 0; i < size; i++) {
            action.accept(elements[i]);
        }
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    public class CustomIterator<T> implements Iterator<T> {
        int position = -1;
        int lastReturned;

        @Override
        public boolean hasNext() {
            return position != size - 1;
        }

        @Override
        public T next() {
            position++;
            lastReturned = position;
            return (T) holder[position];
        }
    }
}