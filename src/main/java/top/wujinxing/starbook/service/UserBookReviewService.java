package top.wujinxing.starbook.service;

import top.wujinxing.starbook.entity.UserBookReview;

import java.util.List;

public interface UserBookReviewService {
    List<UserBookReview> findAll();
    UserBookReview findById();
    UserBookReview addBookReview();
    UserBookReview updateBookReview();
    UserBookReview deleteBookReviewById(Integer reviewId);
}
