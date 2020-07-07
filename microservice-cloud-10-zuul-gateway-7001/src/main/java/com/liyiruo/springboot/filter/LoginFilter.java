package com.liyiruo.springboot.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author liyiruo
 */
@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //请求路由前调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        //int值来定义过滤器的执行顺序，数值越小优先级越高
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        //该过滤器是否执行，true执行，false不执行
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        //获取请求参数token的值
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if (token == null) {
            //logger.warn("此操作需要先登录系统...");
            // 拒绝访问
            context.setSendZuulResponse(false);
            // 设置响应状态码
            context.setResponseStatusCode(200);
            try {
                //响应结果
                context.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        //logger.info("ok");
        return null;
    }
}

