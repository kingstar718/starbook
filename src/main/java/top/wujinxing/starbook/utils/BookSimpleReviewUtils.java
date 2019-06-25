package top.wujinxing.starbook.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import top.wujinxing.starbook.entity.BookSimpleReview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/6/25 19:22
 * description
 */
@Component
public class BookSimpleReviewUtils {
    public List<BookSimpleReview> getBookSimpleReview(String url){
        //String url = "https://book.douban.com/subject/1770782/comments/hot?p=1";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("连接到url失败");
            e.printStackTrace();
        }
        //System.out.println(doc);
        assert doc != null;
        Elements es = doc.getElementsByClass("comment-item");
        List<BookSimpleReview> list = new ArrayList<>();

        for(Element e: es){
            //Thread.sleep(1000);
            BookSimpleReview bookSimpleReview = new BookSimpleReview();
            Integer usefulNum = Integer.parseInt(e.child(1).child(0).child(0).child(0).text());
            String content = e.child(1).child(1).child(0).text();
            String userAddress = e.child(1).child(0).child(1).child(0).attr("href");

            String nameAndTime = e.child(1).child(0).child(1).text();
            String[] nameAndTimeArray = nameAndTime.split(" ");
            String userName = nameAndTimeArray[0];
            String reviewTime = nameAndTimeArray[1];
            Integer reviewId = Integer.parseInt(e.attr("data-cid"));
            //System.out.println(reviewId);

            bookSimpleReview.setReviewId(reviewId);
            bookSimpleReview.setUserName(userName);
            bookSimpleReview.setContent(content);
            bookSimpleReview.setReviewTime(reviewTime);
            bookSimpleReview.setUserAddress(userAddress);
            bookSimpleReview.setUsefulNum(usefulNum);
            list.add(bookSimpleReview);
        }
        return list;
    }
}
