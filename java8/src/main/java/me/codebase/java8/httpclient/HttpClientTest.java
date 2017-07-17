package me.codebase.java8.httpclient;

import org.apache.commons.io.IOUtils;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Created by chendong on 2017/3/17.
 * <p>
 * test
 */
public class HttpClientTest {

    public static void main(String[] args) throws IOException {
        HttpGet get = new HttpGet("http://web.uyundev.cn/apps.main.chunk.ca68b8da3d57b35aeb37.js");
//        System.out.println(Long.MAX_VALUE);
        get.setHeader("Range", "bytes=0-" + Long.MAX_VALUE);
//        get.setHeader("Range", "bytes=0-18446744073709551615");
        CloseableHttpResponse response = HttpClients.createDefault().execute(get);
        StatusLine statusLine = response.getStatusLine();
        System.out.println(statusLine.getStatusCode());
        IOUtils.readLines(response.getEntity().getContent()).forEach(System.out::println);
    }
}
