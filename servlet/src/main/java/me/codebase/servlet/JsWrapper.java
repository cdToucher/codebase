package me.codebase.servlet;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.regex.Pattern;

/**
 * Created by chendong on 2017/6/28.
 */
public class JsWrapper extends HttpServletResponseWrapper {

    private PrintWriter cachedWriter;
    private CharArrayWriter bufferedWriter;

    public JsWrapper(HttpServletResponse response) {
        super(response);
        // 这个是我们保存返回结果的地方
        this.bufferedWriter = new CharArrayWriter();
        // 这个是包装PrintWriter的，让所有结果通过这个PrintWriter写入到bufferedWriter中
        this.cachedWriter = new PrintWriter(this.bufferedWriter);
    }

    @Override
    public PrintWriter getWriter() {
        return this.cachedWriter;
    }

    final String agentJs = "<script>(function(win,doc){win.YYRUM={};YYRUM.info={appId:'23222',beacon:'http://web.uyundev.cn/connect'" +
            ",agent:'http://web.uyundev.cn/buriedPoint/YYRUM.js'};" +
            "var loadSource={createScript:function(src){var d=doc,f=d.getElementsByTagName('script')[0]," +
            "s=d.createElement('script');s.type='text/javascript';s.src=src; f.parentNode.insertBefore(s,f)" +
            ";return s;}};var script=loadSource.createScript(YYRUM.info.agent);win.onerror=function(msg, url," +
            "line,col,error){YYRUM.info.errorData={msg:msg,url:url,line:line,col:col,error:error}};" +
            "if(script.readyState){script.onreadystatechange=function(){if(script.readyState=='loaded'" +
            "||script.readyState=='complete'){script.onreadystatechange=null; YYRUM.report.installGlobalHandler()}};" +
            "}else{script.onload=function(){YYRUM.report.installGlobalHandler()};}})(window,document)</script>";

    /**
     * 通过页面规则将js 注入到相对的页面中
     * <p>
     * agentJs 需要根据不同环境替换
     * inject 方法也需要根据页面规则重写
     */
    String injectJs() {
        String html = this.bufferedWriter.toString();
        Pattern regex = Pattern.compile("<head[^>]*>[\\w\\W]*?</head>");
        return regex.matcher(html).replaceFirst(agentJs);
    }


}
