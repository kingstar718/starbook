package top.wujinxing.starbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.wujinxing.starbook.entity.BookReview;
import top.wujinxing.starbook.service.BookreviewService;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/5/5 16:43
 * description
 */
@Controller
@RequestMapping("/bookreview")
public class BookReviewController {

    @Autowired
    private BookreviewService bookreviewService;

    @GetMapping("/list")
    public String bookReviewList(Model model){
        List<BookReview> bookReviews = bookreviewService.getBookReviewList();
        model.addAttribute("bookReviews", bookReviews);
        return "bookreview/reviewlist";
    }

    @GetMapping("/review")
    public String findReviewById(Model model, @RequestParam("id") long id){
        BookReview bookReview = bookreviewService.findByReviewid(id);
        model.addAttribute("bookReview", bookReview);
        String s = bookReview.getReviewcontent();

        return "bookreview/reviewcontent";
    }
}
