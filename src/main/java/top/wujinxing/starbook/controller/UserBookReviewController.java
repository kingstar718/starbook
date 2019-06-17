package top.wujinxing.starbook.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wujinxing.starbook.entity.UserBookReview;
import top.wujinxing.starbook.service.UserBookReviewService;

import java.util.List;

@Controller
@RequestMapping("userBookReview")
public class UserBookReviewController {

    @Autowired
    private UserBookReviewService userBookReviewService;

    @ResponseBody
    @RequestMapping
    public List<UserBookReview> list(){
        List<UserBookReview> list = userBookReviewService.findAll();
        return list;
    }
}
