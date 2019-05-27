package top.wujinxing.starbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wujinxing
 * date 2019 2019/5/27 9:59
 * description
 */
@Controller
@RequestMapping(value = "/error")
public class MyErrorController implements ErrorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyErrorController.class);


    @Override
    public String getErrorPath() {
        LOGGER.info("出错, 进入自定义错误页面");
        return "error/error";
    }

    @RequestMapping
    public String error(){
        return getErrorPath();
    }
}
