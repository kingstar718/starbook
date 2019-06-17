package top.wujinxing.starbook.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.wujinxing.starbook.service.UserBookReviewService;

@Controller
@RequestMapping("userBookReview")
public class UserBookReviewController {

    @Autowired
    private UserBookReviewService userBookReviewService;

    
}
