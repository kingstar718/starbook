package top.wujinxing.starbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.wujinxing.starbook.dao.BookReviewDao;
import top.wujinxing.starbook.entity.BookReview;
import top.wujinxing.starbook.service.BookreviewService;

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

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    @Override
    public Page<BookReview> findPage(Pageable pageable) {
        return bookReviewDao.findAll(pageable);
    }
}
