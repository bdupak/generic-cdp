package com.epam.logic.container.without_generic;

import com.epam.model.User;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class UserHolder implements Iterable {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity = 0;
    private int size = 0;
    private User[] holder;

    public UserHolder() {
        initHolder(DEFAULT_CAPACITY);
    }

    public UserHolder(int capacity) {
        initHolder(capacity);
    }

    private void initHolder(int capacity) {
        if (capacity >= 0) {
            holder = new User[capacity];
            this.capacity = capacity;
        } else {
            throw new NegativeArraySizeException("The size of container can't be negative");
        }
    }

    public void addElement(User element) {
        if (size == capacity)
            resize();
        holder[size] = element;
        size++;
    }

    private void resize() {
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

    public boolean findElement(User element) {
        for (Object entity : holder) {
            if (entity.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int getIndex(Object element) {
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
    public Iterator iterator() {
        return new UserHolder.CustomIterator();
    }

    @Override
    public void forEach(Consumer action) {
        for (int i = 0; i < size; i++) {
            action.accept(holder[i]);
        }
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    public class CustomIterator implements Iterator {
        int position = -1;
        int lastReturned;

        @Override
        public boolean hasNext() {
            return position != size - 1;
        }

        @Override
        public Object next() {
            position++;
            lastReturned = position;
            return holder[position];
        }
    }
}
