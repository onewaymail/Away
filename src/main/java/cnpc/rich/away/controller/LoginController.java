package cnpc.rich.away.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Map;

@Controller
public class LoginController {
    /***
     * 登录验证跳转
     * @param username 用户名
     * @param password 密码
     * @param map 提示信息
     * @param session 用户sesson
     * @return 返回视图
     */
    @PostMapping("/user/login")
    public String login(@RequestParam String username, @RequestParam String password, Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";//success to main
        } else if (StringUtils.isEmpty(username)) {
            map.put("msg", "用户名不能为空!");
            return "login";//fail 返回错误提示
        } else {
            map.put("msg", "用户名密码错误");
            return "login";//fail 返回错误提示
        }
    }
}
