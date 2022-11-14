package cdu.servie.impl;

import cdu.dao.UserDao;
import cdu.dao.impl.UserDaoImpl;
import cdu.model.User;
import cdu.servie.UserServie;

import java.util.List;

public class UserServiceImpl implements UserServie {
    UserDao userDao=new UserDaoImpl();

    @Override
    public User get(int id) {
        return userDao.findById(id);
    }
public User get(String sid){
        if (sid==null||"".equals(sid)){
            return null;
        }
        else {
            return get(Integer.parseInt(sid));
        }
}
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean add(User user) {
        return userDao.insert(user)==1;
    }

    @Override
    public boolean mod(User user) {
        return userDao.update(user)==1;
    }

    @Override
    public boolean del(int id) {
        return userDao.delete(id)==1;
    }
}
