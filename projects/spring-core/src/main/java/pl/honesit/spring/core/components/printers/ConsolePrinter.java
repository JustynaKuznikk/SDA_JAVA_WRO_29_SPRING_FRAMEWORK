package pl.honesit.spring.core.components.printers;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.honesit.spring.core.qualifiers.Console;

@Component
@Primary
@Console
public class ConsolePrinter implements Printer{
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
