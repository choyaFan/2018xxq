package DAO.impl;

import java.util.List;

import DAO.TempOrderDAO;
import entity.TempOrderEntity;
import entity.UserEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.jsp.tagext.TryCatchFinally;

public class TempOrderDAOImpl implements TempOrderDAO{
	
	private final Session session;
    private Transaction transaction;
    public TempOrderDAOImpl(Session session){
        this.session = session;
    }
    @Override
	public boolean doCreate(TempOrderEntity temporder) {
		boolean flag = false;
		try {
			transaction = session.beginTransaction();
			session.save(temporder);
			transaction.commit();
			flag = true;
		}catch (Exception e) {
		 e.printStackTrace();
		 flag = false;
		}
		if(flag == true) System.out.println("订单下达成功！");
    	else System.out.println("订单下达失败");
    	return flag;
	}
    @Override
	public boolean removeList(TempOrderEntity temporder) {
		boolean flag = false;
		try {
			transaction = session.beginTransaction();
			session.delete(temporder);
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
    @Override
	public List<TempOrderEntity> queryTempOrder(String type, Object value) {
		String hql = "from TempOrderEntity as temporder where temporder." + type + "=?1";
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(1, value);
			List list = query.list();
			transaction.commit();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
