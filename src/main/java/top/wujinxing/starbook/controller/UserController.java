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

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserInfoService userInfoService;

    /*@GetMapping("/list")
    public String userList(Model model){
        List<UserInfo> userInfo = userInfoService.getUserList();
        model.addAttribute("userInfo", userInfo);
        return "user/userlist";
    }*/
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

    //分页
    @RequestMapping("/list")
    public String pageUser(@RequestParam(value = "start", defaultValue = "0") Integer start,
                           @RequestParam(value = "size", defaultValue = "10") Integer size,

                           Model model){
        start = start <0 ? 0:start;
        //Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "userid");
        //Pageable pageable = new PageRequest(start, size, sort);  //方法过时.下面是推荐写法
        Pageable pageable = PageRequest.of(start, size, Sort.by(Sort.Direction.ASC, "userid"));
        Page<UserInfo>  page = userInfoService.findByPage(pageable);
        model.addAttribute("page", page);
        return "user/userlist";
    }

    //分页json
    @RequestMapping("/pageUser")
    @ResponseBody
    public Page<UserInfo> pageUser(@PageableDefault(value = 15, sort = "userid", direction = Sort.Direction.ASC)Pageable pageable){

        return userInfoService.findByPage(pageable);
    }
}
