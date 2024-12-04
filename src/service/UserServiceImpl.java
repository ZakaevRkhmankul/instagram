package service;

import dao.daoImpl.UserDaoImpl;
import model.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    private  UserDaoImpl userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public String addNewUser(User user) {
        return userDao.addNewUser(user);
    }

    @Override
    public User userUpdateByName( String nickName, String password, String photo) {
        return userDao.userUpdateByName(nickName,password,photo);
    }

    @Override
    public User searchByName(String nickName) {
        return userDao.searchByName(nickName);
    }

    @Override
    public List<User> sortByAge(String ascOrDesk) {
        return userDao.sortByAge(ascOrDesk);
    }

    @Override
    public User fikterByAge(String ascOrDesc) {
        return userDao.fikterByAge(ascOrDesc);
    }
}
