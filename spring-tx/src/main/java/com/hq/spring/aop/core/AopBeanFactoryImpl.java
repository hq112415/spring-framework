package com.hq.spring.aop.core;


import com.hq.spring.aop.adapter.AfterRunningAdviceAdapter;
import com.hq.spring.aop.adapter.BeforeMethodAdviceAdapter;
import com.hq.spring.aop.advisor.*;
import com.hq.spring.aop.bean.AopBeanDefinition;
import com.hq.spring.aop.interceptor.AopMethodInterceptor;
import com.hq.spring.ioc.core.BeanFactoryImpl;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Zhengxin
 */
public class AopBeanFactoryImpl extends BeanFactoryImpl {

    private static final ConcurrentHashMap<String,AopBeanDefinition> aopBeanDefinitionMap = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String,Object> aopBeanMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) throws Exception {

        Object aopBean = aopBeanMap.get(name);

        if(aopBean != null){
            return aopBean;
        }

        if(aopBeanDefinitionMap.containsKey(name)){
            AopBeanDefinition aopBeanDefinition = aopBeanDefinitionMap.get(name);
            AdvisedSupport advisedSupport = getAdvisedSupport(aopBeanDefinition);
            aopBean = new CglibAopProxy(advisedSupport).getProxy();
            aopBeanMap.put(name,aopBean);
            return aopBean;
        }

        return super.getBean(name);
    }

    protected void registerBean(String name, AopBeanDefinition aopBeanDefinition){
        aopBeanDefinitionMap.put(name,aopBeanDefinition);
    }

    private AdvisedSupport getAdvisedSupport(AopBeanDefinition aopBeanDefinition) throws Exception {

        AdvisedSupport advisedSupport = new AdvisedSupport();
        List<String> interceptorNames = aopBeanDefinition.getInterceptorNames();
        if(interceptorNames != null && !interceptorNames.isEmpty()){
            for (String interceptorName : interceptorNames) {

                Advice advice = (Advice) getBean(interceptorName);

                Advisor advisor = new Advisor();
                advisor.setAdvice(advice);

                if(advice instanceof BeforeMethodAdvice){
                    AopMethodInterceptor interceptor = BeforeMethodAdviceAdapter.getInstants().getInterceptor(advisor);
                    advisedSupport.addAopMethodInterceptor(interceptor);
                }

                if(advice instanceof AfterRunningAdvice){
                    AopMethodInterceptor interceptor = AfterRunningAdviceAdapter.getInstants().getInterceptor(advisor);
                    advisedSupport.addAopMethodInterceptor(interceptor);
                }

            }
        }

        TargetSource targetSource = new TargetSource();

        Object object = getBean(aopBeanDefinition.getTarget());

        targetSource.setTagetClass(object.getClass());
        targetSource.setTagetObject(object);

        advisedSupport.setTargetSource(targetSource);


        return advisedSupport;

    }

}
