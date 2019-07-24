package cnpc.rich.away.utils;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/***
 * 在连接上携带 区域信息（国际化）
 */
public class MyLocaleReolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lan = request.getParameter("lan");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(lan)){
            //解析前台传过来的参数 ch_CN 和 en_US  语言信息和国家信息
            String[] split = lan.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
