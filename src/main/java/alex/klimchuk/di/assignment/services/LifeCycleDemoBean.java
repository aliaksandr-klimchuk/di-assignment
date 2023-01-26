package alex.klimchuk.di.assignment.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
@Slf4j
@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware {

    public LifeCycleDemoBean() {
        log.info("## I'm in the LifeCycleBean Constructor");
    }

    @Override
    public void destroy() throws Exception {
        log.info("## The Lifecycle bean has been terminated");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("## The LifeCycleBean has its properties set!");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("## Bean Factory has been set");
    }

    @Override
    public void setBeanName(String name) {
        log.info("## My Bean Name is: " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("## Application context has been set");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("## The Post Construct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("## The Predestroy annotated method has been called");
    }

    public void beforeInit() {
        log.info("## - Before Init - Called by Bean Post Processor");
    }

    public void afterInit() {
        log.info("## - After init called by Bean Post Processor");
    }

}
