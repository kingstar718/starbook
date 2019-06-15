package top.wujinxing.starbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.wujinxing.starbook.entity.UserBookReview;

import java.util.List;

public interface UserBookReviewDao extends JpaRepository<UserBookReview, Integer> {
    UserBookReview findByReviewId(Integer reviewId);
    UserBookReview deleteByReviewId(Integer reviewId);
}
