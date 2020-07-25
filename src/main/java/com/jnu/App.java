package com.jnu;

import com.jnu.config.DBConfig1;
import com.jnu.config.DBConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author: zy
 * @Description: 启动代码  打包成war、使用外置tomcat启动
 * @Date: 2020-2-2
 */

@SpringBootApplication
//开启读取配置文件
@EnableConfigurationProperties(value = { DBConfig1.class, DBConfig2.class })
public class App extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }
}