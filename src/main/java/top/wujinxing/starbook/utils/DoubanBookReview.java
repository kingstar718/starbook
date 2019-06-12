package top.wujinxing.starbook.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import top.wujinxing.starbook.entity.SpiderBookReview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * @author wujinxing
 * date 2019 2019/6/11 10:13
 * description 豆瓣书评评论
 */
@Component
public class DoubanBookReview {

    /*private getDoubanBookReview(){

    }*/

    public List<SpiderBookReview> getList(){
        try {
            return getAllBookReview();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SpiderBookReview> getFirstList(){
        String url = "https://book.douban.com/review/best/?start=0";
        List<SpiderBookReview> list = null;
        try {
            list = getBookReview(url);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static List<SpiderBookReview> getAllBookReview() throws IOException, InterruptedException {
        String url = "https://book.douban.com/review/best/?start=";
        List<SpiderBookReview> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            Thread.sleep(2000);
            String url1 = String.format("%s%s", url, String.valueOf(i * 20));
            System.out.println(url1);
            List<SpiderBookReview> list1 = getBookReview(url1);
            Iterator iterator = list1.iterator();
            while (iterator.hasNext()){
                list.add((SpiderBookReview) iterator.next());
            }
        }
        return list;
    }

    //"https://book.douban.com/review/best/"
    private static List<SpiderBookReview> getBookReview(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String entityString = EntityUtils.toString(entity);
        Document doc = Jsoup.parse(entityString);
        //Document doc = Jsoup.connect("https://www.zhihu.com/hot").get();
        Elements s = doc.getElementsByClass("main review-item");
        List<SpiderBookReview> list = new ArrayList<>();

        for (Element e: s
        ) {
            SpiderBookReview sbr = new SpiderBookReview();
            String bookName = e.child(0).child(0).attr("title"); //书名
            String bookReviewAuthor = e.child(1).child(1).text();// 书评作者名
            String bookReviewName = e.child(2).child(0).child(0).text();//书评名
            String bookReviewContent = e.child(2).child(1).child(0).text();//书评简略
            String isUseful = e.child(2).child(3).child(0).text(); //认为评论有用人数
            String isUseless = e.child(2).child(3).child(1).text();  //认为评论无用人数
            //String reviewTime = e.child(1).child(3).text(); //评论时间
            String reviewAddress = e.child(2).child(0).child(0).attr("href"); //书评地址

            //String reviewContent = getReview(reviewAddress); //书评实际内容
            //SpiderBookReview sbr = new SpiderBookReview(bookName, bookReviewAuthor, bookReviewName, bookReviewContent, isUseful, isUseless, reviewTime, reviewAddress);
            sbr.setBookName(bookName);
            sbr.setBookReviewAuthor(bookReviewAuthor);
            sbr.setBookReviewName(bookReviewName);
            sbr.setBookReviewContent(bookReviewContent);
            sbr.setIsUseful(isUseful);
            sbr.setIsUseless(isUseless);
            //sbr.setReviewTime(reviewTime);
            sbr.setReviewAddress(reviewAddress);
            list.add(sbr);
        }

        response.close();
        return list;

    }
    //书评实际内容
    private static String getReview(String url) throws IOException {
        //"https://book.douban.com/review/9593753/"
        Document doc = Jsoup.connect(url).get();
        Elements s = doc.getElementsByClass("review-content clearfix");
        String reviewContent = "";
        for (Element e:s
        ) {
            Elements e1 = e.getElementsByTag("p");
            reviewContent = e1.toString();
        }
        return reviewContent;
    }
}
