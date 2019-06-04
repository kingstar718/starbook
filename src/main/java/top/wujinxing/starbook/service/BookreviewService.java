package top.wujinxing.starbook.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.wujinxing.starbook.entity.BookReview;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/5/5 16:50
 * description
 */
public interface  BookreviewService{
    public List<BookReview> getBookReviewList();

    public BookReview findByReviewid(long reviewid);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<BookReview> findPage(Pageable pageable);
}
