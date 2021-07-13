package com.boot.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@SpringBootApplication
@MapperScan("com.boot.shop.mapper")
public class App implements WebMvcConfigurer {

    /* 项目搭建：1.pom.xml 导入jar包
     * 			2.application.yml 配置springBoot和数据库
     * 			3.App.java是项目的启动类
     * */

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  后台启动成功   ლ(´ڡ`ლ)ﾞ  \n");
        System.out.println(" ________  ___  ___  ________  ________  _______   ________   ________      \n" +
                "|\\   ____\\|\\  \\|\\  \\|\\   ____\\|\\   ____\\|\\  ___ \\ |\\   ____\\ |\\   ____\\     \n" +
                "\\ \\  \\___|\\ \\  \\\\\\  \\ \\  \\___|\\ \\  \\___|\\ \\   __/|\\ \\  \\___|_\\ \\  \\___|_    \n" +
                " \\ \\_____  \\ \\  \\\\\\  \\ \\  \\    \\ \\  \\    \\ \\  \\_|/_\\ \\_____  \\\\ \\_____  \\   \n" +
                "  \\|____|\\  \\ \\  \\\\\\  \\ \\  \\____\\ \\  \\____\\ \\  \\_|\\ \\|____|\\  \\\\|____|\\  \\  \n" +
                "    ____\\_\\  \\ \\_______\\ \\_______\\ \\_______\\ \\_______\\____\\_\\  \\ ____\\_\\  \\ \n" +
                "   |\\_________\\|_______|\\|_______|\\|_______|\\|_______|\\_________\\\\_________\\\n" +
                "   \\|_________|                                      \\|_________\\|_________|\n  \n");
    }

    // TODO 上传图片

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/shop/**").addResourceLocations("file:E:/a_resources/a_resources/create/shop/");
    }

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> connector.setProperty("relaxedQueryChars", "|{}[]\\"));
        return factory;
    }

}
