package DAO;
import java.util.List;
import entity.GoodsEntity;
public interface GoodsDAO {
		
		boolean CreatGoods(GoodsEntity goods);
	    boolean UpdateGoods(GoodsEntity goods);
	    boolean DeleteGoods(GoodsEntity goods);
	    List<GoodsEntity> FindGoods(String attribute,Object value);
	    List<GoodsEntity> FindGoodsFuzzySearchByGoodsContent(String content);
	    List<GoodsEntity> FindGoodsFuzzySearchByGoodsNmae(String name);
	    List<GoodsEntity> FindGoodsByPriceIntervals(double minprice,double maxprice);
}
