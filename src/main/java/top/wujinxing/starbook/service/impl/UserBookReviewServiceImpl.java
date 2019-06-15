package top.wujinxing.starbook.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import top.wujinxing.starbook.dao.UserBookReviewDao;
import top.wujinxing.starbook.entity.UserBookReview;
import top.wujinxing.starbook.service.UserBookReviewService;

import java.util.List;

public class UserBookReviewServiceImpl implements UserBookReviewService {

    @Autowired
    private UserBookReviewDao userBookReviewDao;


    @Override
    public List<UserBookReview> findAll() {
        return userBookReviewDao.findAll();
    }

    @Override
    public UserBookReview findById(Integer reviewId) {
        return null;
    }

    @Override
    public UserBookReview addBookReview(UserBookReview userBookReview) {
        return null;
    }

    @Override
    public UserBookReview updateBookReview(UserBookReview userBookReview) {
        return null;
    }

    @Override
    public UserBookReview deleteBookReviewById(Integer reviewId) {
        return null;
    }
}
