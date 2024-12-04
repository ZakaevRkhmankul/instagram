package service;

import model.User;

import java.util.List;

public interface UserService {
    String addNewUser(User user);

    User userUpdateByName( String nickName, String password, String photo);

    User searchByName(String nickName);

    List<User> sortByAge(String ascOrDesk);

    User fikterByAge(String ascOrDesc);
}
