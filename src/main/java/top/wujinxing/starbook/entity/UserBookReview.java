package top.wujinxing.starbook.entity;

import javax.persistence.Entity;
import java.util.Date;

/**
 * 用户评论内容
 */
@Entity
public class UserBookReview {
    private Integer userId;
    private String userName;
    private String userEmail;
    private Date reviewTime;
    private String reviewContent;
    private Integer bookId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "UserBookReview{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", reviewTime=" + reviewTime +
                ", reviewContent='" + reviewContent + '\'' +
                ", bookId=" + bookId +
                '}';
    }
}
