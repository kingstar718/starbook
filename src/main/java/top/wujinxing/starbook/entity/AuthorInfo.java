package top.wujinxing.starbook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wujinxing
 * date 2019 2019/5/14 15:34
 * description
 */
@Entity
public class AuthorInfo implements Serializable {

    @Id
    @GeneratedValue
    private Long authorId;
    private String authorName;
    private String authorAlias;
    private String authorMagnumopus;
    private Date authorBirth;
    private String authorNationality;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorAlias() {
        return authorAlias;
    }

    public void setAuthorAlias(String authorAlias) {
        this.authorAlias = authorAlias;
    }

    public String getAuthorMagnumopus() {
        return authorMagnumopus;
    }

    public void setAuthorMagnumopus(String authorMagnumopus) {
        this.authorMagnumopus = authorMagnumopus;
    }

    public Date getAuthorBirth() {
        return authorBirth;
    }

    public void setAuthorBirth(Date authorBirth) {
        this.authorBirth = authorBirth;
    }

    public String getAuthorNationality() {
        return authorNationality;
    }

    public void setAuthorNationality(String authorNationality) {
        this.authorNationality = authorNationality;
    }

    @Override
    public String toString() {
        return "AuthorInfo{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", authorAlias='" + authorAlias + '\'' +
                ", authorMagnumopus='" + authorMagnumopus + '\'' +
                ", authorBirth=" + authorBirth +
                ", authorNationality='" + authorNationality + '\'' +
                '}';
    }
}
