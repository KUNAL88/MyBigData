package com.spark.practice.config;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Properties;

public class AppConfig {

    private String filePath=null;
    private Boolean isLocal=null;
    private Properties prop;
    public AppConfig(String configPath){

        Configuration config=new Configuration();
        //conf.addResource();

        FileSystem fs=null;
        URI uri=URI.create(configPath);

        if(configPath.startsWith("file:")){
            try {
                fs= LocalFileSystem.get(uri,config);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                fs=FileSystem.get(uri,config);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Path path=new Path(configPath);

        prop=new Properties();
        try {
            prop.load(new InputStreamReader(fs.open(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        loadConfig();
    }

    private void loadConfig(){
        isLocal=Boolean.parseBoolean(prop.getProperty(Constant.LOCAL));
    }

    public Boolean getIsLocal() {
        return isLocal;
    }
}
