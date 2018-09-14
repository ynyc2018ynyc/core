package com.ctj.portal.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class MainController {

    /**
     * 系统主页
     *
     * @param request HttpServletRequest
     * @param map     Map<String, Object>
     * @return String
     */
    @RequestMapping(value = {"/", "/main"})
    public String main(HttpServletRequest request, Map<String, Object> map) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
        map.put("path", path);
        map.put("basePath", basePath);
        return "main";
    }

    /**
     * 路径跳转
     *
     * @param path String
     * @return String
     */
    @RequestMapping("/to{path}")
    public String pathJump(@PathVariable String path) {
        return path;
    }
}
