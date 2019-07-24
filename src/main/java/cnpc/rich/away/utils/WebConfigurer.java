package cnpc.rich.away.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private LoginHandlerInterceptor loginHandlerInterceptor;

    /**
     * 试图 映射  所有的拦截器都会一起起作用
     * uriPath:代表请求路径；setViewName：html文件名称；
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/login");
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/index.html").setViewName("/login");//用于中英文切换
        registry.addViewController("/main.html").setViewName("/syspage/main");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/**").
                excludePathPatterns("/", "/user/login", "/login").
                excludePathPatterns("/webjars/**","/asserts/**","/bower_componets/**");
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleReolver();
    }

}