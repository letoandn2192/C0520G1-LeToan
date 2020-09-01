package model;

import java.util.Comparator;

public class SortUserByName implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        User user_1 = (User) o1;
        User user_2 = (User) o2;
        return user_1.getName().compareTo(user_2.getName());
    }
}
