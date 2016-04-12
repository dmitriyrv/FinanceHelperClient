package com.helper.finance.client.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dvas on 11.04.2016.
 */
@Configuration
public class DozerConfig {

    @Autowired


    @Bean
    public DozerBeanMapper dozerBeanMapper() throws IOException {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

        dozerBeanMapper.setMappingFiles(listMappingFiles());
        return dozerBeanMapper;
    }

    private List<String> listMappingFiles(){
        List<String> mappingFiles = new ArrayList<>();

        mappingFiles.add("classpath*:/dozer-bean-mappings.xml");

        return mappingFiles;
    }
}
