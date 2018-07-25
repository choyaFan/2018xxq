package DAO;

import DAO.impl.UserDAOImpl;
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
}
