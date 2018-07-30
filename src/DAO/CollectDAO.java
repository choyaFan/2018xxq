package DAO;

import entity.CollectEntity;
import entity.GoodsEntity;
import entity.UserEntity;
import java.util.List;

import java.util.List;
public interface CollectDAO {
	public boolean CollectOne(CollectEntity collect);
	public List<GoodsEntity> FindGoodsByUser(UserEntity user);
	public boolean RemoveOne(CollectEntity collect);
}
