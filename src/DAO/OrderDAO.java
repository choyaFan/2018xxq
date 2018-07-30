package DAO;

import java.util.List;

import entity.OrderEntity;

public interface OrderDAO {
	String insertOrder(OrderEntity order);
	String deleteOrder(OrderEntity order);
	List queryOrder(String type,Object value);
}
