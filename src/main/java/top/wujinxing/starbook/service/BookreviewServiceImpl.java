package top.wujinxing.starbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wujinxing.starbook.dao.BookReviewDao;
import top.wujinxing.starbook.entity.BookReview;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/5/5 16:51
 * description
 */
@Service
public class BookreviewServiceImpl implements BookreviewService {

    @Autowired
    private BookReviewDao bookReviewDao;

    @Override
    public List<BookReview> getBookReviewList() {
        return bookReviewDao.findAll();
    }

    @Override
    public BookReview findByReviewid(long reviewid) {
        return bookReviewDao.findByReviewid(reviewid);
    }
}
