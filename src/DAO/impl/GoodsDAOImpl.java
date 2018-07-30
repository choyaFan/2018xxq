package DAO.impl;

import DAO.GoodsDAO;

import java.util.List;
import entity.GoodsEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Param;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class GoodsDAOImpl implements GoodsDAO {
	
	private final Session session;
    private Transaction transaction;

    public GoodsDAOImpl(Session session){
        this.session = session;
    }
    @Override
    public boolean CreatGoods(GoodsEntity goods) {
    	boolean flag = false;
    	try {
			transaction = session.beginTransaction();
			session.save(goods);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
    	if(flag == true) System.out.println("上架物品成功！");
    	else System.out.println("上架物品失败！");
    	return flag;
    }
    @Override
    public boolean UpdateGoods(GoodsEntity goods) {
     	boolean flag = false;
    	try {
			transaction = session.beginTransaction();
			session.update(goods);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
    	if(flag == true) System.out.println("修改信息成功！");
    	else System.out.println("修改信息失败！");
    	return flag;
    }
    @Override
    public boolean DeleteGoods(GoodsEntity goods) {
     	boolean flag = false;
    	try {
			transaction = session.beginTransaction();
			session.delete(goods);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
    	if(flag == true) System.out.println("下架物品成功！");
    	else System.out.println("下架物品失败！");
    	return flag;
    }
    @Override
    public List<GoodsEntity> FindGoods(String attribute,Object value) {
    	String hql = "from GoodsEntity as goods where goods." + attribute + "=?1";
    	System.out.println("queryInfo sql:" + hql + "value = " + value);
    	try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(1, value);
			List<GoodsEntity> list = query.list();
			transaction.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    @Override
    public List<GoodsEntity> FindGoodsFuzzySearchByGoodsContent(String content){
    	String hql = "from GoodsEntity as goods where goods.content like '%" + content +"%'";
    	System.out.println("queryInfo sql:" + hql );
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
    public List<GoodsEntity> FindGoodsFuzzySearchByGoodsNmae(String name){
    	String hql = "from GoodsEntity as goods where goods.name like '%" + name +"%'";
    	System.out.println("queryInfo sql:" + hql );
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
    public List<GoodsEntity> FindGoodsByPriceIntervals(double minprice,double maxprice) {
    	String hql = "from GoodsEntity as goods where goods.price between " + minprice + " and " + maxprice;
    	System.out.println("queryInfo sql:" + hql);
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
 
}
