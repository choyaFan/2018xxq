package DAO.impl;
import java.util.List;

import DAO.CollectDAO;
import entity.CollectEntity;
import entity.GoodsEntity;
import entity.UserEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.jsp.tagext.TryCatchFinally;
public class CollectDAOImpl implements CollectDAO {
	private final Session session;
    private Transaction transaction;

    public CollectDAOImpl(Session session){
        this.session = session;
    }
    @Override
    public boolean CollectOne(CollectEntity collect) {
    	boolean flag = false;
    	try {
			transaction = session.beginTransaction();
			session.save(collect);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			 e.printStackTrace();
			 flag = false;
		}
    	if(flag == true) System.out.println("收藏成功！");
    	else System.out.println("收藏失败");
    	return flag;
    }
    @Override
	public List<GoodsEntity> FindGoodsByUser(UserEntity user) {
		String hql = "from GoodsEntity as goods where goods.id =(select goodsId from CollectEntity as collect where collect.userId ="+user.getId()+")";
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			List<GoodsEntity> list = query.list();
			transaction.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
    @Override
	public boolean RemoveOne(CollectEntity collect) {
		boolean flag = false;
		try {
			transaction = session.beginTransaction();
			session.delete(collect);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		if(flag == true) System.out.println("删除成功！");
    	else System.out.println("删除失败");
    	return flag;
	}
}
