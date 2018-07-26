package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "javademo", catalog = "")
public class UserEntity {
    private String img;
    private int id;
    private String email;
    private String pwd;
    private String name;
    private String stuNum;
    private String qq;
    private String phone;
    private int messNum;

    @Basic
    @Column(name = "img", nullable = true, length = 255)
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "pwd", nullable = false, length = 255)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "stu_num", nullable = true, length = 255)
    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    @Basic
    @Column(name = "qq", nullable = true, length = 255)
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "mess_num", nullable = false)
    public int getMessNum() {
        return messNum;
    }

    public void setMessNum(int messNum) {
        this.messNum = messNum;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserEntity that = (UserEntity) object;
        return id == that.id &&
                messNum == that.messNum &&
                Objects.equals(img, that.img) &&
                Objects.equals(email, that.email) &&
                Objects.equals(pwd, that.pwd) &&
                Objects.equals(name, that.name) &&
                Objects.equals(stuNum, that.stuNum) &&
                Objects.equals(qq, that.qq) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(img, id, email, pwd, name, stuNum, qq, phone, messNum);
    }
}
