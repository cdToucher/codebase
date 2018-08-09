package me.codebase.common.test;


import me.codebase.common.utils.PoolSizeCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SimplePoolSizeCaculatorTest extends PoolSizeCalculator {

    @Override
    protected Runnable creatTask() {
        return new AsyncIOTask();
    }

    @Override
    protected BlockingQueue<Runnable> createWorkQueue() {
        return new LinkedBlockingQueue<>(1000);
    }

    @Override
    protected long getCurrentThreadCPUTime() {
        return ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
    }

    public void test() {
        PoolSizeCalculator poolSizeCalculator = new SimplePoolSizeCaculatorTest();
        poolSizeCalculator.calculateBoundaries(BigDecimal.valueOf(1), new BigDecimal(1000));
    }
}

/**
 * 自定义的异步IO任务
 *
 * @author Will
 */
class AsyncIOTask implements Runnable {//NOSONAR

    @Override
    public void run() {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            String getURL = "http://risk-engine.tuiatest.cn/remoteRuleEngineService/operator" +
                    "?_p0=%7B%22consumerId%22:%226615379000%22,%22deviceId%22:%22wewerw%22,%22sceneKey%22:%22tuia_launch%22" +
                    ",%22ip%22:%22%22,%22ua%22:%22%22,%22platform%22:%22%22,%22date%22:%22%22,%22mediaId%22:%22%22,%22soltId%22" +
                    ":%22%22,%22phone%22:%22%22,%22appVersion%22:%22%22%7D";
            URL getUrl = new URL(getURL);

            connection = (HttpURLConnection) getUrl.openConnection();
            connection.connect();
            reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                // empty loop
            }
        } catch (IOException e) {

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {

                }
            }
        }
    }
}
