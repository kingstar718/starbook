package top.wujinxing.starbook.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.wujinxing.starbook.dao.BookReviewDao;
import top.wujinxing.starbook.entity.BookReview;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wujinxing
 * date 2019 2019/5/6 10:51
 * description
 */
public class BookreviewServiceImplTest {

    @Resource
    private BookReviewDao bookReviewDao;

    @Test
    public void test1(){
        long id = 2;
        BookReview bookReview = bookReviewDao.findByReviewid(id);
        System.out.println(bookReview.getReviewcontent());


    }

}