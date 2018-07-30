package DAO;

import java.util.List;

import entity.GoodsEntity;
import entity.ShoppingcartEntity;
import entity.UserEntity;
import entity.TempOrderEntity;

	public interface TempOrderDAO{
		public boolean doCreate(TempOrderEntity temporder) throws Exception;
		public boolean removeList(TempOrderEntity temporder) throws Exception;
		public List<TempOrderEntity> queryTempOrder(String type, Object value) throws Exception;
	}
