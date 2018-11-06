package me.codebase.es.config;

import com.google.common.io.Resources;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Properties;

/**
 * Elastic search singleton
 * <p>
 * For get es high level rest client
 */
public class ElasticConfig {

    private static final Logger LOGGER = LogManager.getLogger(ElasticConfig.class);

    private static class InnerClass {
        private static final ElasticConfig INSTANCE = new ElasticConfig();
    }

    public static RestHighLevelClient getInstance() {
        return InnerClass.INSTANCE.getRestHighLevelClient();
    }

    private ElasticConfig() {
        this.restHighLevelClient = initClient();
    }

    private RestHighLevelClient restHighLevelClient;

    private RestHighLevelClient getRestHighLevelClient() {
        return restHighLevelClient;
    }

    private Properties prepareConfig() throws IOException {
        URL url = Resources.getResource("application.properties");
        Properties properties = new Properties();
        properties.load(Resources.asByteSource(url).openStream());
        return properties;
    }

    public static String INDEX_NAME = "TEST";
    public static String CLUSTER_NAME = "elasticsearch";
    public static String[] HOSTS = {"127.0.0.1:9300"};

    /**
     * @return RestHighLevelClient config
     */
    private RestHighLevelClient initClient() {
        RestHighLevelClient client = null;
        try {
            Properties properties = prepareConfig();
            INDEX_NAME = properties.getProperty("dev.elasticsearch.index.name", "test");
            CLUSTER_NAME = properties.getProperty("dev.elasticsearch.cluster.name", "elasticsearch");
            String hosts = properties.getProperty("dev.elasticsearch.hosts", "localhost:9300");
            final String userName = properties.getProperty("dev.elasticsearch.userName", null);
            final String pwd = properties.getProperty("dev.elasticsearch.pwd", null);
            HOSTS = hosts.split(",");

            HttpHost[] httpHosts = Arrays.stream(HOSTS).map(str -> {
                String[] arr = str.split(":");
                HttpHost httpHost = null;
                try {
                    httpHost = new HttpHost(InetAddress.getByName(arr[0]), Integer.parseInt(arr[1]));
                } catch (UnknownHostException e) {
                    LOGGER.error("Add host failed! {}", arr[0]);
                }
                return httpHost;
            }).toArray(value -> new HttpHost[HOSTS.length]);
            CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(userName, pwd));
            RestClientBuilder restClientBuilder = RestClient.builder(httpHosts)
                    .setHttpClientConfigCallback((HttpAsyncClientBuilder httpClientBuilder) -> {
                        httpClientBuilder.disableAuthCaching();
                        return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                    })
                    .setRequestConfigCallback(requestConfigBuilder -> requestConfigBuilder.setConnectTimeout(6000)
                            .setSocketTimeout(3000))
                    .setFailureListener(new RestClient.FailureListener() {
                        @Override
                        public void onFailure(HttpHost host) {
                            LOGGER.warn("a request failure on host: {}", host);
                        }
                    })
                    .setMaxRetryTimeoutMillis(3000);
            client = new RestHighLevelClient(restClientBuilder);
        } catch (Exception e) {
            LOGGER.error("ElasticSearch init failed..." + e.getMessage());
        }
        return client;
    }

}
