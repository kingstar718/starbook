package top.wujinxing.starbook.entity;

import java.io.Serializable;

/**
 * @author wujinxing
 * date 2019 2019/6/11 10:20
 * description
 */
public class SpiderBookReview implements Serializable {
    private Integer reviewId;
    private String bookName;
    private String bookReviewAuthor;
    private String bookReviewName;
    private String bookReviewContent;
    private String isUseful;
    private String isUseless;
    private String reviewTime;
    private String reviewAddress;

    public SpiderBookReview() {
    }

    public SpiderBookReview(String bookName, String bookReviewAuthor, String bookReviewName, String bookReviewContent, String isUseful, String isUseless, String reviewTime, String reviewAddress) {
        this.bookName = bookName;
        this.bookReviewAuthor = bookReviewAuthor;
        this.bookReviewName = bookReviewName;
        this.bookReviewContent = bookReviewContent;
        this.isUseful = isUseful;
        this.isUseless = isUseless;
        this.reviewTime = reviewTime;
        this.reviewAddress = reviewAddress;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookReviewAuthor() {
        return bookReviewAuthor;
    }

    public void setBookReviewAuthor(String bookReviewAuthor) {
        this.bookReviewAuthor = bookReviewAuthor;
    }

    public String getBookReviewName() {
        return bookReviewName;
    }

    public void setBookReviewName(String bookReviewName) {
        this.bookReviewName = bookReviewName;
    }

    public String getBookReviewContent() {
        return bookReviewContent;
    }

    public void setBookReviewContent(String bookReviewContent) {
        this.bookReviewContent = bookReviewContent;
    }

    public String getIsUseful() {
        return isUseful;
    }

    public void setIsUseful(String isUseful) {
        this.isUseful = isUseful;
    }

    public String getIsUseless() {
        return isUseless;
    }

    public void setIsUseless(String isUseless) {
        this.isUseless = isUseless;
    }

    public String getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(String reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getReviewAddress() {
        return reviewAddress;
    }

    public void setReviewAddress(String reviewAddress) {
        this.reviewAddress = reviewAddress;
    }

    @Override
    public String toString() {
        return "SpiderBookReview{" +
                "bookName='" + bookName + '\'' +
                ", bookReviewAuthor='" + bookReviewAuthor + '\'' +
                ", bookReviewName='" + bookReviewName + '\'' +
                ", bookReviewContent='" + bookReviewContent + '\'' +
                ", isUseful='" + isUseful + '\'' +
                ", isUseless='" + isUseless + '\'' +
                ", reviewTime='" + reviewTime + '\'' +
                ", reviewAddress='" + reviewAddress + '\'' +
                '}';
    }
}
