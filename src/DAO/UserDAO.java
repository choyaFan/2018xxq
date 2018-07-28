package DAO;

import entity.UserEntity;

import java.util.List;

public interface UserDAO {
    String insertUser(UserEntity userEntity);
    String updateUser(UserEntity userEntity);
    List<UserEntity> queryInfo(String type, Object value);
}
