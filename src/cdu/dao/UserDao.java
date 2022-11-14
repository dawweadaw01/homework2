package cdu.dao;

import cdu.model.User;
import java.util.List;

public interface UserDao {

    User findById(int id);
    List<User> findAll();
    int insert(User user);
    int update(User user);
    int delete(int id);
}
