package me.codebase.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by chendong on 2017/6/28.
 * <p>
 * 这里的 @WebFilter 可以改为通过 web.xml 注入
 */
@WebFilter(urlPatterns = {"*"})
public class JsFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        final String contentType = "text/html";

        // 使用我们自定义的响应包装器来包装原始的ServletResponse
        JsWrapper wrapper = new JsWrapper((HttpServletResponse) servletResponse);
        filterChain.doFilter(servletRequest, wrapper);

        String result = "";
        if (servletResponse.getContentType() != null && servletResponse.getContentType().contains(contentType)) {
            result = wrapper.injectJs();
        }

        servletResponse.setContentLength(-1);

        PrintWriter out = servletResponse.getWriter();
        out.write(result);
        out.flush();
        out.close();
    }

}
