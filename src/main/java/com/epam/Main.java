package com.epam;

import com.epam.logic.container.generic.GenericHolder;
import com.epam.model.User;

public class Main {
    public static void main(String[] args) {
        GenericHolder<User> holder = new GenericHolder<>();
        for(int i = 0; i < 100; i++) {
            holder.addElement(new User("user" + i, "user" + 1, i));
        }
        for(int i = 0; i < holder.size(); i++) {
            System.out.println(holder.getElement(i));
        }
    }
}
