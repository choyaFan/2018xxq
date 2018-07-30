package DAO;

import DAO.impl.*;
import org.hibernate.Session;

public class DAOFactory {
    private static volatile DAOFactory mInstance;
    private DAOFactory(){}

    public static DAOFactory getmInstance(){
        if(mInstance == null){
            synchronized (DAOFactory.class){
                if(mInstance == null) mInstance = new DAOFactory();
            }
        }
        return mInstance;
    }

    public UserDAO getUserDAO(Session session){
        return new UserDAOImpl(session);
    }
    public CollectDAO getCollectDAO(Session session) {
    	return new CollectDAOImpl(session);
    }
    public GoodsDAO getGoodsDAO(Session session) {
    	return new GoodsDAOImpl(session);
    }
    public MessageDAO getMessageDAO(Session session) {
    	return new MessageDAOImpl(session);
    }
    public OrderDAO getOrderDAO(Session session) {
    	return new OrderDAOImpl(session);
    }
    public ShoppingcartDAO getShoppingcartDAO(Session session) {
    	return new ShoppingcartDAOImpl(session);
    }
    public TempOrderDAO getTempOrderDAO(Session session) {
    	return new TempOrderDAOImpl(session);
    }
}
