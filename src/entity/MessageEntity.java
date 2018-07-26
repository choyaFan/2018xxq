package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "message", schema = "javademo", catalog = "")
public class MessageEntity {
    private int messFromId;
    private int messToId;
    private String messText;
    private Timestamp sendTime;
    private int messId;
    private Integer messType;

    @Basic
    @Column(name = "mess_from_id", nullable = false)
    public int getMessFromId() {
        return messFromId;
    }

    public void setMessFromId(int messFromId) {
        this.messFromId = messFromId;
    }

    @Basic
    @Column(name = "mess_to_id", nullable = false)
    public int getMessToId() {
        return messToId;
    }

    public void setMessToId(int messToId) {
        this.messToId = messToId;
    }

    @Basic
    @Column(name = "mess_text", nullable = false, length = 255)
    public String getMessText() {
        return messText;
    }

    public void setMessText(String messText) {
        this.messText = messText;
    }

    @Basic
    @Column(name = "send_time", nullable = false)
    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    @Id
    @Column(name = "mess_id", nullable = false)
    public int getMessId() {
        return messId;
    }

    public void setMessId(int messId) {
        this.messId = messId;
    }

    @Basic
    @Column(name = "mess_type", nullable = true)
    public Integer getMessType() {
        return messType;
    }

    public void setMessType(Integer messType) {
        this.messType = messType;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        MessageEntity that = (MessageEntity) object;
        return messFromId == that.messFromId &&
                messToId == that.messToId &&
                messId == that.messId &&
                Objects.equals(messText, that.messText) &&
                Objects.equals(sendTime, that.sendTime) &&
                Objects.equals(messType, that.messType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(messFromId, messToId, messText, sendTime, messId, messType);
    }
}
