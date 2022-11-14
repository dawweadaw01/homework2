package cdu.servie;

import cdu.model.User;

import java.util.List;

public interface UserServie {
    User get(int id);
    User get(String sid);
    List<User> findAll();

    boolean add(User user);
    boolean mod(User user);
    boolean del(int id);
}
