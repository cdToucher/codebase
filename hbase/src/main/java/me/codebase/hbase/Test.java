package me.codebase.hbase;

import com.google.common.io.Resources;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.Properties;

public class Test {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(Resources.asByteSource(Resources.getResource("application.properties"))
                .openStream());
        String zkAddress = properties.getProperty("duiba.hbase.zk-quorum");
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", zkAddress);

        HTable d;

        try (HBaseAdmin hBaseAdmin = new HBaseAdmin(config)) {
            Get get = new Get(Bytes.toBytes(""));
//            hBaseAdmin.get
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
