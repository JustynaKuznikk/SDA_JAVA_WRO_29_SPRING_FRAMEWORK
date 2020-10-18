package pl.honesit.spring.core.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import pl.honesit.spring.core.config.WarmUpConfiguration;
import pl.honesit.spring.core.warmup.HelloWorld;

public class Application {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WarmUpConfiguration.class);

//        context.scan("pl.honesit.spring.core.warmup");
//        context.refresh();

        HelloWorld bean = context.getBean("helloBean", HelloWorld.class);
        bean.sayHello();

        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
        helloWorld.sayHello();

        System.out.println(bean == helloWorld);

        HelloWorld bean2 = context.getBean("helloBean", HelloWorld.class);
        HelloWorld helloWorld2 = context.getBean("helloWorld", HelloWorld.class);

        System.out.println(bean == bean2);
        System.out.println(helloWorld == helloWorld2);

        HelloWorld buzzBuzz = context.getBean("buzzBuzz", HelloWorld.class);
        buzzBuzz.sayHello();

        try {
            HelloWorld bean3 = context.getBean(HelloWorld.class);
            bean3.sayHello();
        }catch (RuntimeException re){
            //re.printStackTrace();
            System.out.println(re.getLocalizedMessage());

        }






    }
        private static void classPathWarmUp() {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
            HelloWorld bean = context.getBean("helloWorld", HelloWorld.class);
            bean.sayHello();

        }


    public static void genericContext(){

        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("helloWorld", HelloWorld.class);
        //musimy odświeżyć kontekst po przygotowaniu go
        context.refresh();

        //pobieranie beana 1
        HelloWorld bean = (HelloWorld) context.getBean("helloWorld");
        bean.sayHello();

        //metoda sparametryzowana pobierania 2
        bean = context.getBean("helloWorld", HelloWorld.class);
        bean.sayHello();

        //kontekst po samym typie - najprzyjemniejsza 3
        bean = context.getBean(HelloWorld.class);
        bean.sayHello();
    }
}
