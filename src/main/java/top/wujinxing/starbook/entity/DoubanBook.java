package top.wujinxing.starbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author wujinxing
 * date 2019 2019/6/10 9:25
 * description
 */
@Entity
@Table(name = "doubanbook250")
public class DoubanBook implements Serializable {
    @Id
    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "book_address")
    private String bookAddress;
    @Column(name = "book_img")
    private String bookImg;
    @Column(name = "book_author")
    private String bookAuthor;
    @Column(name = "book_score")
    private String bookScore;
    @Column(name = "book_evaluate")
    private String bookEvaluate;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAddress() {
        return bookAddress;
    }

    public void setBookAddress(String bookAddress) {
        this.bookAddress = bookAddress;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookScore() {
        return bookScore;
    }

    public void setBookScore(String bookScore) {
        this.bookScore = bookScore;
    }

    public String getBookEvaluate() {
        return bookEvaluate;
    }

    public void setBookEvaluate(String bookEvaluate) {
        this.bookEvaluate = bookEvaluate;
    }

    @Override
    public String toString() {
        return "DoubanBook{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAddress='" + bookAddress + '\'' +
                ", bookImg='" + bookImg + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookScore='" + bookScore + '\'' +
                ", bookEvaluate='" + bookEvaluate + '\'' +
                '}';
    }
}
