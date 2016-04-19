package com.helper.finance.client.configuration;

import com.helper.finance.client.service.impl.LoginDetailsServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;
import org.dozer.DozerBeanMapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dvas on 11.04.2016.
 */
@Configuration
public class AppConfig {

    @Bean
    public DozerBeanMapperFactoryBean dozerBeanMapper() throws IOException {
        DozerBeanMapperFactoryBean dozerBeanMapper = new DozerBeanMapperFactoryBean();
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath*:dozer-bean-mappings.xml");
        dozerBeanMapper.setMappingFiles(resources);
        return dozerBeanMapper;
    }

    private List<String> listMappingFiles(){
        List<String> mappingFiles = new ArrayList<>();

        mappingFiles.add("classpath*:/dozer-bean-mappings.xml");

        return mappingFiles;
    }

    @Bean
    public ObjectMapper jacksonMapper(){
        return new ObjectMapper();
    }

    @Bean
    public UserDetailsService getUserDetailsService(){
        return new LoginDetailsServiceImpl();
    }
}
