package Lumiamuyu.dao;

import Lumiamuyu.pojo.User;
import Lumiamuyu.utilTest.JDBCUtil;
import Lumiamuyu.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    @Override
    public int insert(User user) {
        return JDBCUtil.executeUpdate("insert into user(username,password,telephone) values(?,?,?)",user.getUsername(),user.getPassword(),user.getTelephone());
    }

    @Override
    public User getOne(String username) {
        return JDBCUtil.queryOne("select username,password,telephone from user where username=?", new RowMap<User>() {
            @Override
            public User RowMapping(ResultSet resultSet) {
                User u = new User();
                try {
                    u.setUsername(resultSet.getString("username"));
                    u.setPassword(resultSet.getString("password"));
                    u.setTelephone(resultSet.getString("telephone"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return u;
            }
        }, username);
    }

}
