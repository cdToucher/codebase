package me.codebase.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", "localhost");

        try (Admin hBaseAdmin = new HBaseAdmin(config)) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
