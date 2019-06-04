package top.wujinxing.starbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    /*@GetMapping("/list")
    public String bookReviewList(Model model){
        List<BookReview> bookReviews = bookreviewService.getBookReviewList();
        model.addAttribute("bookReviews", bookReviews);
        return "bookreview/reviewlist";
    }*/

    @GetMapping("/list")
    public String findPage(@RequestParam(value = "start", defaultValue = "0")Integer start,
                           @RequestParam(value = "size", defaultValue = "10")Integer size,
                           Model model){
        start = start < 0 ? 0 : start;
        Pageable pageable = PageRequest.of(start, size, Sort.by(Sort.Direction.ASC, "reviewid"));
        Page<BookReview> page = bookreviewService.findPage(pageable);
        model.addAttribute("page", page);
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
