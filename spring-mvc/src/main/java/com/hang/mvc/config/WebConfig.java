package hang.mvc.config;

import com.hang.mvc.config.JdbcMvcConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @ClassName WebConfig
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/21 021 18:53
 * @Version 1.0
 */

public class WebConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext cxt
                =new AnnotationConfigWebApplicationContext();
        cxt.register(JdbcMvcConfig.class);
        //注册转发器Servelt
        DispatcherServlet servlet=new DispatcherServlet(cxt);
        ServletRegistration.Dynamic registration=servletContext.addServlet("app",servlet);
        //设置服务器在启动时加载
        registration.setLoadOnStartup(1);
        //转发全部请求，必须配置响应地址是
        registration.addMapping("/");
    }
}
