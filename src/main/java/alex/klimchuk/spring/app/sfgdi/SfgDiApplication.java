package alex.klimchuk.spring.app.sfgdi;

import alex.klimchuk.spring.app.sfgdi.controllers.*;
import alex.klimchuk.spring.app.sfgdi.datasource.FakeDataSource;
import alex.klimchuk.spring.app.sfgdi.configs.SfgdiConfig;
import alex.klimchuk.spring.app.sfgdi.configs.SfgdiConstructorConfig;
import alex.klimchuk.spring.app.sfgdi.services.PrototypeBean;
import alex.klimchuk.spring.app.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.ComponentScan;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"alex.klimchuk.spring.app.sfgdi", "alex.klimchuk.spring.app.pets"})
public class SfgDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println("--- The Best Pet is ---");
        System.out.println(petController.whichPetIsTheBest());

        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        MyController myController = (MyController) ctx.getBean("myController");

        System.out.println("---------- Primary Bean ----------");
        System.out.println(myController.sayHello());

        System.out.println("---------- Property ----------");
        PropertyInjectedController propertyInjectedController =
                (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("---------- Setter ----------");
        SetterInjectedController setterInjectedController =
                (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("---------- Constructor ----------");
        ConstructorInjectedController constructorInjectedController =
                (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

        System.out.println("---------- Bean Scopes ----------");
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getScope());
        System.out.println(singletonBean2.getScope());

        PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getScope());
        System.out.println(prototypeBean2.getScope());

        System.out.println("---------- Fake Props Bean ----------");
        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUsername());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getJdbcUrl());

        System.out.println("---------- Config Props Bean ----------");
        SfgdiConfig sfgdiConfig = ctx.getBean(SfgdiConfig.class);
        System.out.println(sfgdiConfig.getUsername());
        System.out.println(sfgdiConfig.getPassword());
        System.out.println(sfgdiConfig.getJdbcUrl());

        System.out.println("---------- Constructor Binding ----------");
        SfgdiConstructorConfig sfgdiConstructorConfig = ctx.getBean(SfgdiConstructorConfig.class);
        System.out.println(sfgdiConstructorConfig.getUsername());
        System.out.println(sfgdiConstructorConfig.getPassword());
        System.out.println(sfgdiConstructorConfig.getJdbcUrl());
    }

}
