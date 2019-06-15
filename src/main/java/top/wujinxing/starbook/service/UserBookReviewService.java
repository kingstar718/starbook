package top.wujinxing.starbook.service;

import top.wujinxing.starbook.entity.UserBookReview;

import java.util.List;

public interface UserBookReviewService {
    List<UserBookReview> findAll();
    UserBookReview findById(Integer reviewId);
    UserBookReview addBookReview(UserBookReview userBookReview);
    UserBookReview updateBookReview(UserBookReview userBookReview);
    UserBookReview deleteBookReviewById(Integer reviewId);
}
