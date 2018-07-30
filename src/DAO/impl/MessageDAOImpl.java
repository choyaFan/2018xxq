package DAO.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DAO.MessageDAO;
import entity.MessageEntity;

public class MessageDAOImpl implements MessageDAO {
	
	private final Session session;
	private Transaction transaction;
	
	public MessageDAOImpl(Session session) {
		this.session = session;
	}

	@Override
	public String insertMessage(MessageEntity message) {
		// TODO Auto-generated method stub
		String result;
		try {
			transaction = session.beginTransaction();
			session.save(message);
			transaction.commit();
			result = "消息发布成功";
		}catch (Exception e) {
			e.printStackTrace();
			result = "消息发布失败";
		}
		return result;
	}

	@Override
	public String updateMessage(MessageEntity message) {
		// TODO Auto-generated method stub
		String result;
		try {
			transaction = session.beginTransaction();
			session.update(message);
			transaction.commit();
			result = "消息修改成功";
		}catch(Exception e) {
			e.printStackTrace();
			result = "消息修改失败";
		}
		return result;
	}

	@Override
	public String deleteMessage(MessageEntity message) {
		// TODO Auto-generated method stub
		String result;
		try {
			transaction = session.beginTransaction();
			session.delete(message);
			transaction.commit();
			result = "消息删除成功";
		}catch(Exception e) {
			e.printStackTrace();
			result = "消息删除失败";
		}
		return result;
	}

	@Override
	public List<MessageEntity> queryMessage(String type,Object value) {
		// TODO Auto-generated method stub
		String hql = "from MessageEntity as mess where mess." + type + "=?1";
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(1,value);
			List<MessageEntity> list = query.list();
			transaction.commit();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
