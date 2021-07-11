package com.hufe.frame;

import com.hufe.frame.aop.FrameInterceptor;
import com.hufe.frame.constant.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Slf4j
@MapperScan("com.hufe.frame.mapper")
public class FrameApplication implements WebMvcConfigurer {

  public static void main(String[] args) {
    // apollo配置
    // System.setProperty("apollo.configService", "http://config-service-url:port");
    SpringApplication.run(FrameApplication.class, args);
    log.info("frame start on http://localhost:18080,version: " + CommonConstant.FRAME_VERSION);
  }

  @Bean
  FrameInterceptor getFrameInterceptor() {
    return new FrameInterceptor();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(getFrameInterceptor())
            .addPathPatterns("/api/**");
  }

}
