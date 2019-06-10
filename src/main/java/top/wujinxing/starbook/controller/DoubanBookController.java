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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wujinxing.starbook.entity.DoubanBook;
import top.wujinxing.starbook.service.DoubanBookService;

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
}
