package DAO;

import entity.UserEntity;

import java.util.List;

public interface UserDAO {
    String insertUser(UserEntity userEntity);
    String updateUser(UserEntity userEntity);
    List queryInfo(String type, Object value);
}
