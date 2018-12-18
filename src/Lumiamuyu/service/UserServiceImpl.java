package Lumiamuyu.service;

import Lumiamuyu.dao.IUserDao;
import Lumiamuyu.dao.UserDaoImpl;
import Lumiamuyu.pojo.User;

public class UserServiceImpl implements IUserService {
    private IUserDao dao = new UserDaoImpl();

    @Override
    public int insert(User user) {
        return dao.insert(user);
    }

    @Override
    public User getOne(String username) {
        return dao.getOne(username);
    }
}
