package DAO;


import java.util.List;

import entity.GoodsEntity;
import entity.ShoppingcartEntity;
import entity.UserEntity;

	public interface ShoppingcartDAO{
		public boolean doSaveShoppingCart(ShoppingcartEntity shoppingcart) throws Exception;//添加
		public List<ShoppingcartEntity> queryShoppingcart(String type , Object value) throws Exception;//查找
		public boolean removeList(ShoppingcartEntity shoppingcart) throws Exception;//删除一件
	}
