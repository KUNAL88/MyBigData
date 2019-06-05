package com.kunal.config;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Level;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Properties;

import static com.kunal.config.Constants.*;

public class KafkaConfig {

    private Properties prop;
    private String kafkaTopic;
    private String kafkaBootstarpServer;
    private String consumerGroup;
    private Level logLevel=Level.WARN;
  //  private int partitionCount;
    private boolean islocal;
    private String zkServer;

    public KafkaConfig(String configPath) throws IOException{

        Configuration config=new Configuration();
        //conf.addResource();

        FileSystem fs=null;
        URI uri=URI.create(configPath);

        if(configPath.startsWith("file:")){
            fs= LocalFileSystem.get(uri,config);
        }else {
            fs=FileSystem.get(uri,config);
        }

        Path path=new Path(configPath);

        prop=new Properties();
        prop.load(new InputStreamReader(fs.open(path)));

        initialize();
        fs.close();

    }

    private void initialize(){

        kafkaTopic=prop.getProperty(KAFKA_TOPIC);
        kafkaBootstarpServer=prop.getProperty(KAFKA_BOOTSTRAP_SERVER);
        consumerGroup=prop.getProperty(GROUP_ID);
       // logLevel=prop.getProperty(LOCAL);
        islocal=Boolean.parseBoolean(prop.getProperty(LOCAL));
        zkServer=prop.getProperty(ZK_SERVER);
    }

    public String getKafkaTopic() {
        return kafkaTopic;
    }

    public String getKafkaBootstarpServer() {
        return kafkaBootstarpServer;
    }

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public Level getLogLevel() {
        return logLevel;
    }

    public boolean getIslocal() {
        return islocal;
    }

    public String getZkServer() {
        return zkServer;
    }

    @Override
    public String toString() {
        return "KafkaConfig{" +
                //"prop=" + prop +
                ", kafkaTopic='" + kafkaTopic + '\'' +
                ", kafkaBootstarpServer='" + kafkaBootstarpServer + '\'' +
                ", consumerGroup='" + consumerGroup + '\'' +
                ", logLevel=" + logLevel +
                ", islocal='" + islocal + '\'' +
                ", zkServer='" + zkServer + '\'' +
                '}';
    }
}
