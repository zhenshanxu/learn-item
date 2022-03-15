package com.example.learnitem.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.ctrl
 * @Author: ZhenShanXu
 * @CreateTime: 2022-03-15 10:26.
 * @Description: 静态索引控制
 */

@Controller
public class IndexCtrl {

    @GetMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        System.out.println("页面重定向");
        return "build:index";
    }

}
