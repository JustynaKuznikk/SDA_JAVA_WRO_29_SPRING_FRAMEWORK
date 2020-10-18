package pl.honesit.spring.core.components.printers;

import org.springframework.stereotype.Component;

@Component
public class ConsolePrinter implements Printer{
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
