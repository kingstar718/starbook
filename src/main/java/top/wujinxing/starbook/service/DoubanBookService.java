package top.wujinxing.starbook.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.wujinxing.starbook.entity.BookSimpleReview;
import top.wujinxing.starbook.entity.DoubanBook;
import top.wujinxing.starbook.entity.SpiderBookReview;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/6/10 9:31
 * description
 */
public interface DoubanBookService  {

    Page<DoubanBook> findPage(Pageable pageable);

    DoubanBook findById(Integer bookId);

    List<SpiderBookReview> getListBookReview();

    List<SpiderBookReview> getFirstList();
    List<SpiderBookReview> getReviewByNum(Integer num);

    Page<SpiderBookReview> findReviewPage(int start, int size);

    List<BookSimpleReview> findFirstReview(String url);
}
