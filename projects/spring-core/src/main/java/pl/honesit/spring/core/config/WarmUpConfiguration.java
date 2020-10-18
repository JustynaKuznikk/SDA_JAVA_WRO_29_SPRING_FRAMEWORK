package pl.honesit.spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.honesit.spring.core.components.printers.ConsolePrinter;
import pl.honesit.spring.core.warmup.HelloWorld;

@Configuration
@ComponentScan(basePackages = "pl.honesit.spring.core")
//nie musze wywoływać scan i refresh w application.java
public class WarmUpConfiguration {


    @Bean
    public HelloWorld helloBean(){
        return new HelloWorld();
    }

    @Bean
    public HelloWorld buzzBuzz(){
        return new HelloWorld();
    }


}
