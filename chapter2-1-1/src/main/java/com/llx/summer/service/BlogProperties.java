package com.llx.summer.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * @Auther: sharps
 * @Date: 19-3-28 09:52
 * @Description:
 */
@Component
@PropertySource(value = {"classpath:application.properties"},encoding="utf-8")
@Data
public class BlogProperties {
    @Value("${com.llx.summer.blog.name}")
    private String name;
    @Value("${com.llx.summer.blog.title}")
    private String title;

    @Value("${com.llx.summer.blog.value}")
    private String value;

    @Value("${com.llx.summer.blog.number}")
    private Integer number;

    @Value("${com.llx.summer.blog.uuid}")
    private String uuid;

    @Value("${com.llx.summer.blog.desc}")
    private String desc;



}
