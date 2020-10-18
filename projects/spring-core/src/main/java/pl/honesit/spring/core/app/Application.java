package pl.honesit.spring.core.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import pl.honesit.spring.core.warmup.HelloWorld;

public class Application {
    public static void main(String[] args) {
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
