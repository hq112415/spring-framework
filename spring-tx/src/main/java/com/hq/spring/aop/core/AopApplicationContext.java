package com.hq.spring.aop.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.hq.spring.aop.bean.AopBeanDefinition;
import com.hq.spring.ioc.bean.BeanDefinition;
import com.hq.spring.ioc.utils.ClassUtils;
import com.hq.spring.ioc.utils.JsonUtils;

import java.io.InputStream;
import java.util.List;

public class AopApplicationContext extends AopBeanFactoryImpl {

    private String fileName;

    public AopApplicationContext(String fileName) {
        this.fileName = fileName;
    }

    public void init() {
        loadFile();
    }

    private void loadFile() {

        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

        List<AopBeanDefinition> beanDefinitions = JsonUtils.readValue(is, new TypeReference<List<AopBeanDefinition>>() {
        });

        if (beanDefinitions != null && !beanDefinitions.isEmpty()) {

            for (AopBeanDefinition beanDefinition : beanDefinitions) {
                Class<?> clz = ClassUtils.loadClass(beanDefinition.getClassName());
                if (clz == ProxyFactoryBean.class) {
                    registerBean(beanDefinition.getName(), beanDefinition);
                } else {
                    registerBean(beanDefinition.getName(), (BeanDefinition) beanDefinition);
                }
            }
        }

    }


}
