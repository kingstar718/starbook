package top.wujinxing.starbook.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wujinxing
 * date 2019 2019/5/5 16:44
 * description
 */
@Entity
@Table(name = "bookreview")
public class BookReview implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "reviewid")
    private long reviewid;

    @Column(name = "reviewauthor")
    private String reviewauthor;

    @Column(name = "reviewtime")
    private Date reviewtime;

    @Column(name = "bookname")
    private String bookname;

    @Column(name = "reviewname")
    private String reviewname;

    @Column(name = "reviewcontent")
    private String reviewcontent;

    public long getReviewid() {
        return reviewid;
    }

    public void setReviewid(long reviewid) {
        this.reviewid = reviewid;
    }

    public String getReviewauthor() {
        return reviewauthor;
    }

    public void setReviewauthor(String reviewauthor) {
        this.reviewauthor = reviewauthor;
    }

    public Date getReviewtime() {
        return reviewtime;
    }

    public void setReviewtime(Date reviewtime) {
        this.reviewtime = reviewtime;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getReviewname() {
        return reviewname;
    }

    public void setReviewname(String reviewname) {
        this.reviewname = reviewname;
    }

    public String getReviewcontent() {
        return reviewcontent;
    }

    public void setReviewcontent(String reviewcontent) {
        this.reviewcontent = reviewcontent;
    }
}
