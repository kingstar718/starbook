package top.wujinxing.starbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.wujinxing.starbook.entity.AuthorInfo;
import top.wujinxing.starbook.service.AuthorService;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/5/23 9:38
 * description
 */
@Controller
@RequestMapping("/author")
public class AuthorController {
    private final static Logger LOGGER = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private AuthorService authorService;

    @GetMapping("/list")
    public String authorList(Model model){
        List<AuthorInfo> list = authorService.findAll();
        LOGGER.info("查询所有列表 " + list.toString() + " 列表长度: " + list.size());
        model.addAttribute("list", list);
        return "author/authorList";
    }

    @GetMapping("/findById")
    public String findById(Model model, @RequestParam("authorId") Long authorId){
        AuthorInfo authorInfo = authorService.findById(authorId);
        model.addAttribute("authorInfo", authorInfo);
        return "author/authorInfo";
    }

    @PostMapping("/addAuthor")
    public String addAuthor(AuthorInfo authorInfo){
        AuthorInfo authorInfo1 = authorService.insert(authorInfo);
        LOGGER.info("添加的作者信息:" + authorInfo1.toString());
        return "redirect:authorList";
    }

    @RequestMapping("/deleteById")
    public String deleteById(Long authorId){
        AuthorInfo authorInfo = authorService.findById(authorId);
        if (authorInfo==null){
            LOGGER.info("用户ID不存在");
        }else {
            AuthorInfo authorInfo1 = authorService.delete(authorId);
            LOGGER.info("删除的用户信息: "+ authorInfo1.toString());
        }
        return "redirect:authorList";
    }
}
