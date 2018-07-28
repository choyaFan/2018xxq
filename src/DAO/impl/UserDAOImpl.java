package DAO.impl;

import DAO.UserDAO;
import entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    private final Session session;
    private Transaction transaction;

    public UserDAOImpl(Session session){
        this.session = session;
    }
    @Override
    public String insertUser(UserEntity user){
        String result;
        System.out.println(user.getName());
        System.out.println(user.getPwd());
        try{
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            result = "用户：" + user.getName() + "注册成功！";
        }catch (Exception e){
            e.printStackTrace();
            result = "注册失败: " + e;
        }

        return result;
    }

    @Override
    public String updateUser(UserEntity user){
        String result;

        try{
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            result = "用户：" + user.getName() + "信息更新成功!";
        }catch (Exception e){
            e.printStackTrace();
            result = "信息更新失败" + e;
        }

        return result;
    }

    @Override
    public List<UserEntity> queryInfo(String type, Object value){
        String hql = "from UserEntity as user where user." + type + "=?1";
        System.out.println("queryInfo sql " + hql + " value = " + value);

        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(1, value);
            List<UserEntity> list = query.list();
            transaction.commit();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
