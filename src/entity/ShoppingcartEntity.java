package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shoppingcart", schema = "javademo", catalog = "")
public class ShoppingcartEntity {
    private int id;
    private int goodsId;
    private int userId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "goodsId", nullable = false)
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "userId", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ShoppingcartEntity that = (ShoppingcartEntity) object;
        return id == that.id &&
                goodsId == that.goodsId &&
                userId == that.userId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, goodsId, userId);
    }
}
