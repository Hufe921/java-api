package com.hufe.frame;

import com.hufe.frame.aop.FrameInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.TimeZone;

@SpringBootApplication
@Slf4j
public class FrameApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(FrameApplication.class, args);
        log.info("frame start on http://localhost:18080");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FrameInterceptor())
                .addPathPatterns("/api/**");
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonBuilderCustomizer() {
        return builder -> {
            builder.timeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        };
    }

}
