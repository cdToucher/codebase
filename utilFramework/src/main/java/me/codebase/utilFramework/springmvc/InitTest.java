package me.codebase.utilFramework.springmvc;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InitTest implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        final RestTemplate restTemplate = RestTemplateTest.context.getBean(RestTemplate.class);
        ResponseEntity<String> responseEntity = restTemplate.exchange("https://chanshike.cn//appKey.txt"
                , HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), String.class);
        System.out.println(responseEntity.getStatusCodeValue());
    }

}
