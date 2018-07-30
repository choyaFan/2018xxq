package DAO.impl;

import java.util.List;

import DAO.ShoppingcartDAO;
import entity.ShoppingcartEntity;
import entity.UserEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.jsp.tagext.TryCatchFinally;

public class ShoppingcartDAOImpl implements ShoppingcartDAO{
	private final Session session;
    private Transaction transaction;
    
    public ShoppingcartDAOImpl(Session session){
        this.session = session;
    }
    @Override
    public boolean doSaveShoppingCart(ShoppingcartEntity shoppingcart) {
    	boolean flag = false;
    	try {
			transaction = session.beginTransaction();
			session.save(shoppingcart);
			transaction.commit();
			flag = true;
    	}catch (Exception e) {
			 e.printStackTrace();
			 flag = false;
		}
    	if(flag == true) System.out.println("添加成功！");
    	else System.out.println("添加失败");
    	return flag;
    }
    
    @Override
   	public List<ShoppingcartEntity> queryShoppingcart(String type , Object value) {
    	String hql = "from ShoppingcartEntity as shoppingcart where shoppingcart." + type + "=?1";
		System.out.println("queryInfo sql:" + hql + "value = " + value);
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(1, value);
			List<ShoppingcartEntity> list = query.list();
			transaction.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
    @Override
    public boolean removeList(ShoppingcartEntity shoppingcart) {
    	boolean flag = false;
    	try {
			transaction = session.beginTransaction();
			session.delete(shoppingcart);
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
