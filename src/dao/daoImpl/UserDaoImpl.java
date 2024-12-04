package dao.daoImpl;

import dao.UserDao;
import database.Database;
import model.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static database.Database.users;

public class UserDaoImpl implements UserDao {

    @Override
    public String addNewUser(User user) {
        users.add(user);
        return "кошулду";
    }

    @Override
    public User userUpdateByName(String nickName, String password, String photo) {
        for (User user : users) {
            if (user.getNickName().equalsIgnoreCase(nickName)) {
                user.setPassword(user.getNickName());
                user.setPfoto(user.getPfoto());
                return user;
            }
        }
        return null;
    }

    @Override
    public User searchByName(String nickName) {
        for (User user : users) {
            if (user.getNickName().equalsIgnoreCase(nickName)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> sortByAge(String ascOrDesk) {
       return users.stream().sorted(ascOrDesk.equalsIgnoreCase("desc")
               ? Comparator.comparingInt(User::getAge)
               : Comparator.comparingInt(User::getAge).reversed()).collect(Collectors.toList());
    }

    @Override
    public User fikterByAge(String ascOrDesc) {
        return users.stream()
                .sorted(ascOrDesc.equalsIgnoreCase("asc")
                        ? Comparator.comparingInt(User::getAge)
                        : Comparator.comparingInt(User::getAge).reversed())
                .findFirst()
                .get();
    }
}
