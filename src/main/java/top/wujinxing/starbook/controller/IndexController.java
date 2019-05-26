package top.wujinxing.starbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {

    @RequestMapping()
    public String toUserList(){
        return "index";
    }

    @RequestMapping("/toMapService")
    public String toMapService(){
        return "map/mapService";
    }
}
