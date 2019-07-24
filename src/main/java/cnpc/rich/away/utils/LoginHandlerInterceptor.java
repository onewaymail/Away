package cnpc.rich.away.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 没有登录成功的不能访问系统页面
 */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if(user ==null){
            //未登录
            request.setAttribute("msg","没有权限访问，请先登录");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else{
            //已登录
            return true;
        }
    }
}
