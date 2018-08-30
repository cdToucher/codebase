package me.codebase.es;

import com.google.common.io.Resources;
import org.apache.http.HttpHost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Created by chendong on 2018/4/7.
 */
public class ElasticSearchService {

    private static final Logger logger = LogManager.getLogger(ElasticSearchService.class);

    private ElasticSearchService() {
        initClient();
    }

    private static class InnerClass {
        private static final ElasticSearchService instance = new ElasticSearchService();
    }

    public static ElasticSearchService getInstance() {
        return InnerClass.instance;
    }

    private String indexName;
    private String clusterName;
    private String ipList;
    private RestHighLevelClient client = null;

    private static Properties prepareConfig() throws IOException {
        URL url = Resources.getResource("application.properties");
        Properties properties = new Properties();
        properties.load(Resources.asByteSource(url).openStream());
        return properties;
    }

    private RestHighLevelClient initClient() {
        try {
            Properties properties = prepareConfig();
            this.indexName = properties.getProperty("elasticsearch.index.name", "test");
            this.clusterName = properties.getProperty("elasticsearch.cluster.name", "elasticsearch");
            this.ipList = properties.getProperty("elasticsearch.hosts", "localhost:9300");

            Settings settings = Settings.builder()
                    .put("cluster.name", clusterName).build();
            HttpHost[] hosts = (HttpHost[]) Arrays.stream(ipList.split(",")).map(str -> {
                String[] arr = str.split(":");
                HttpHost httpHost = null;
                try {
                    httpHost = new HttpHost(InetAddress.getByName(arr[0]), Integer.parseInt(arr[1]), "http");
                } catch (UnknownHostException e) {
                    logger.error("Add host failed! {}", arr[0]);
                }
                return httpHost;
            }).collect(Collectors.toList()).toArray();
            this.client = new RestHighLevelClient(RestClient.builder(hosts));
        } catch (Exception e) {
            logger.error("ElasticSearch initial failed..." + e.getMessage());
        }
        return client;
    }


}
