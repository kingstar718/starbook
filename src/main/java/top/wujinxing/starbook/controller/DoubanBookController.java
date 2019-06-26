package top.wujinxing.starbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.wujinxing.starbook.entity.BookSimpleReview;
import top.wujinxing.starbook.entity.DoubanBook;
import top.wujinxing.starbook.entity.SpiderBookReview;
import top.wujinxing.starbook.service.DoubanBookService;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/6/10 9:34
 * description
 */
@Controller
@RequestMapping(("/doubanbook"))
public class DoubanBookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoubanBookController.class);

    @Autowired
    private DoubanBookService doubanBookService;

    @RequestMapping("/findById/{id}")
    @ResponseBody
    public DoubanBook findById(@PathVariable(name = "id") Integer id){
        DoubanBook book = doubanBookService.findById(id);
        LOGGER.info(book.toString());
        return doubanBookService.findById(id);
    }

    @RequestMapping("/findPage")
    @ResponseBody
    public Page<DoubanBook> findPage(@PageableDefault(value = 15, sort = "bookId", direction = Sort.Direction.ASC)Pageable pageable){
        return doubanBookService.findPage(pageable);
    }

    @RequestMapping("/list")
    public String pageList(@RequestParam(value = "start", defaultValue = "0") Integer start,
                           @RequestParam(value = "size", defaultValue = "10") Integer size,
                           Model model){
        start = start <0 ? 0:start;
        Pageable pageable = PageRequest.of(start, size, Sort.by(Sort.Direction.ASC, "bookId"));
        Page<DoubanBook> page = doubanBookService.findPage(pageable);
        model.addAttribute("page", page);
        return "douban/book250";
    }

    //书评展示
    @GetMapping("/bookReviewList")
    @ResponseBody
    public List<SpiderBookReview> bookReviewList(){
        return doubanBookService.getListBookReview();
    }

    @GetMapping("/bookFirstReviewList")
    @ResponseBody
    public List<SpiderBookReview> bookReviews(){
        return doubanBookService.getFirstList();
    }

    @GetMapping("/getFirstReview")
    public String getFirstReview(@RequestParam(value = "num", defaultValue = "0")Integer num,
                                 Model model){
        num = num <0 ? 0: num;
        num = num >9 ? 9: num;
        List<SpiderBookReview> bookReviews = doubanBookService.getReviewByNum(num);
        model.addAttribute("bookReviews", bookReviews);
        return "douban/doubanReview";
    }

    @GetMapping("/reviewPage")
    public String reviewPage(@RequestParam(value = "start", defaultValue = "0") Integer start,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Model model){
        start = start <0 ? 0:start;
        Page<SpiderBookReview> page = doubanBookService.findReviewPage(start, size);
        model.addAttribute("page", page);
        return "douban/allReview";
    }

    @GetMapping("/simpleReview")
    //@ResponseBody
    public String simplePage(@RequestParam(value = "url") String url,
                             @RequestParam(value = "p", defaultValue = "1")Integer p,
                             Model model){
        List<BookSimpleReview> list = doubanBookService.findFirstReview(url, p);
        model.addAttribute("list", list);
        return "douban/simpleReview";
    }

    @GetMapping("/simpleNewReview")
    public String simpleNewPage(@RequestParam(value = "url") String url,
                                @RequestParam(value = "p", defaultValue = "1")Integer p,
                                Model model){
        List<BookSimpleReview> list = doubanBookService.findNewReview(url, p);
        model.addAttribute("list", list);
        return "douban/simpleReview";
    }

    @GetMapping("/simpleNext")
    @ResponseBody
    public DoubanBook simpleNext(@RequestParam(value = "bookId")Integer bookId){
        DoubanBook doubanBook = doubanBookService.findById(bookId);
        System.out.println(doubanBook.toString());
        return doubanBook;
    }
}
