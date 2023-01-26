package alex.klimchuk.di.assignment;

import alex.klimchuk.di.assignment.controllers.*;
import alex.klimchuk.di.assignment.datasource.FakeDataSource;
import alex.klimchuk.di.assignment.configs.SfgDiConfig;
import alex.klimchuk.di.assignment.configs.SfgDiConstructorConfig;
import alex.klimchuk.di.assignment.services.PrototypeBean;
import alex.klimchuk.di.assignment.services.SingletonBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.ComponentScan;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
@Slf4j
@SpringBootApplication
//@ComponentScan(basePackages = {"alex.klimchuk.di.assignment", "alex.klimchuk.di.pets"})
public class SfgDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        PetController petController = ctx.getBean("petController", PetController.class);
        log.info("--- The Best Pet is ---");
        log.info(petController.whichPetIsTheBest());

        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        log.info(i18nController.sayHello());

        MyController myController = (MyController) ctx.getBean("myController");

        log.info("---------- Primary Bean ----------");
        log.info(myController.sayHello());

        log.info("---------- Property ----------");
        PropertyInjectedController propertyInjectedController =
                (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        log.info(propertyInjectedController.getGreeting());

        log.info("---------- Setter ----------");
        SetterInjectedController setterInjectedController =
                (SetterInjectedController) ctx.getBean("setterInjectedController");
        log.info(setterInjectedController.getGreeting());

        log.info("---------- Constructor ----------");
        ConstructorInjectedController constructorInjectedController =
                (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        log.info(constructorInjectedController.getGreeting());

        log.info("---------- Bean Scopes ----------");
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        log.info(singletonBean1.getScope());
        log.info(singletonBean2.getScope());

        PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
        log.info(prototypeBean1.getScope());
        log.info(prototypeBean2.getScope());

        log.info("---------- Fake Props Bean ----------");
        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        log.info(fakeDataSource.getUsername());
        log.info(fakeDataSource.getPassword());
        log.info(fakeDataSource.getJdbcUrl());

        log.info("---------- Config Props Bean ----------");
        SfgDiConfig sfgdiConfig = ctx.getBean(SfgDiConfig.class);
        log.info(sfgdiConfig.getUsername());
        log.info(sfgdiConfig.getPassword());
        log.info(sfgdiConfig.getJdbcUrl());

        log.info("---------- Constructor Binding ----------");
        SfgDiConstructorConfig sfgdiConstructorConfig = ctx.getBean(SfgDiConstructorConfig.class);
        log.info(sfgdiConstructorConfig.getUsername());
        log.info(sfgdiConstructorConfig.getPassword());
        log.info(sfgdiConstructorConfig.getJdbcUrl());
    }

}
