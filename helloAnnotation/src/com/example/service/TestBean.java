package com.example.service;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

//@Component(value = "test")
public class TestBean implements ResourceLoaderAware {
    private ResourceLoader resourceLoader;
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    private Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void parse(){
        System.out.println("文件名称："+resource.getFilename());
        System.out.println("文件描述："+resource.getDescription());
        System.out.println("文件是否存在："+resource.exists());
        System.out.println("文件是否打开："+resource.isOpen());
    }
}
