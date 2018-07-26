package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "collect", schema = "javademo", catalog = "")
public class CollectEntity {
    private int collectId;
    private Integer userId;
    private Integer goodsId;

    @Id
    @Column(name = "collect_id", nullable = false)
    public int getCollectId() {
        return collectId;
    }

    public void setCollectId(int collectId) {
        this.collectId = collectId;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "goods_id", nullable = true)
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CollectEntity that = (CollectEntity) object;
        return collectId == that.collectId &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(goodsId, that.goodsId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(collectId, userId, goodsId);
    }
}
