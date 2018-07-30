package DAO.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DAO.OrderDAO;
import entity.OrderEntity;

public class OrderDAOImpl implements OrderDAO {

	private final Session session;
	private Transaction transaction;
	
	public OrderDAOImpl(Session session) {
		this.session = session;
	}
	
	@Override
	public String insertOrder(OrderEntity order) {
		// TODO Auto-generated method stub
		String result;
		try {
			transaction = session.beginTransaction();
			session.save(order);
			transaction.commit();
			result = "创建订单成功";
		}catch(Exception e) {
			e.printStackTrace();
			result = "创建订单失败";
		}
		return result;
	}

	@Override
	public String deleteOrder(OrderEntity order) {
		// TODO Auto-generated method stub
		String result;
		try {
			transaction = session.beginTransaction();
			session.delete(order);
			transaction.commit();
			result = "删除订单成功";
		}catch(Exception e) {
			e.printStackTrace();
			result = "删除订单失败";
		}
		return result;
	}

	@Override
	public List<OrderEntity> queryOrder(String type, Object value) {
		// TODO Auto-generated method stub
		String hql = "from OrderEntity as order where order." + type + "=?1";
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(1, value);
			List<OrderEntity> list = query.list();
			transaction.commit();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
