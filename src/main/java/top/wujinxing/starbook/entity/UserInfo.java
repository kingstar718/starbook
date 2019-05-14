package top.wujinxing.starbook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author wujinxing
 * date 2019 2019/5/5 10:18
 * description
 */
@Entity
@Table(name = "userinfo")
public class UserInfo implements Serializable {

    @Id
    @GeneratedValue
    private long userid;
    private String username;
    private String password;
    private int age;

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
