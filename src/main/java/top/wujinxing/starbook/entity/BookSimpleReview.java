package top.wujinxing.starbook.entity;

/**
 * @author wujinxing
 * date 2019 2019/6/25 17:21
 * description
 */
public class BookSimpleReview {
    private Integer reviewId;
    private String userName;
    private String content;
    private  String userAddress;
    private String reviewTime;
    private Integer usefulNum;

    public BookSimpleReview() {
    }

    public BookSimpleReview(Integer reviewId, String userName, String content, String userAddress, String reviewTime, Integer usefulNum) {
        this.reviewId = reviewId;
        this.userName = userName;
        this.content = content;
        this.userAddress = userAddress;
        this.reviewTime = reviewTime;
        this.usefulNum = usefulNum;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(String reviewTime) {
        this.reviewTime = reviewTime;
    }

    public Integer getUsefulNum() {
        return usefulNum;
    }

    public void setUsefulNum(Integer usefulNum) {
        this.usefulNum = usefulNum;
    }
}
