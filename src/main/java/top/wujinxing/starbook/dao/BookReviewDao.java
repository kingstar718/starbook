package top.wujinxing.starbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.wujinxing.starbook.entity.BookReview;

/**
 * @author wujinxing
 * date 2019 2019/5/5 16:44
 * description
 */
public interface BookReviewDao extends JpaRepository<BookReview, Long> {

    public BookReview findByReviewid(long reviewid);
}
