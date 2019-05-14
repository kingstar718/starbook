package top.wujinxing.starbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.wujinxing.starbook.entity.UserInfo;
import top.wujinxing.starbook.service.UserInfoService;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/5/5 10:32
 * description
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/list")
    public String userList(Model model){
        List<UserInfo> userInfo = userInfoService.getUserList();
        model.addAttribute("userInfo", userInfo);
        return "user/userlist";
    }
    @GetMapping("/findById")
    public String findById(Model model, @RequestParam("id") long id){
        UserInfo user = userInfoService.findByUserid(id);
        model.addAttribute("user", user);
        return "user/user";
    }

    @RequestMapping("/deleteById")
    public String deleteById(Long id){
        userInfoService.deleteByUserid(id);
        //List<UserInfo> userInfo = userInfoService.getUserList();
        //model.addAttribute("userinfo", userInfo);
        return "redirect:list";     //很奇怪,重定向到这个方法, 而不是视图
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "/user/userAdd";
    }

    @RequestMapping(value = "/add")
    public String add(UserInfo userInfo){
        System.out.println(userInfo.getUsername() + " " + userInfo.getPassword());
        userInfoService.insert(userInfo);
        return "redirect:list";
    }
}
