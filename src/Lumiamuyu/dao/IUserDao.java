package Lumiamuyu.dao;

import Lumiamuyu.pojo.User;

public interface IUserDao {
    public int insert(User user);
    public User getOne(String username);
}
