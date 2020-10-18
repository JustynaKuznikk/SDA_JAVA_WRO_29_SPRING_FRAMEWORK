package pl.honesit.spring.core.warmup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.honesit.spring.core.components.printers.ConsolePrinter;
import pl.honesit.spring.core.components.printers.DialogPrinter;
import pl.honesit.spring.core.components.printers.FilePrinter;
import pl.honesit.spring.core.components.printers.Printer;
import pl.honesit.spring.core.qualifiers.Console;

import java.util.Random;

@Component
public class HelloWorld {
    private Printer consolePrinter;
    private Printer dialogPrinter;
    private Printer somePrinter;



    public HelloWorld() {
    }

    @Autowired
    public HelloWorld(@Console Printer consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

//    @Autowired
//    public void setDialogPrinter(DialogPrinter dialogPrinter) {
//        this.dialogPrinter = dialogPrinter;
//    }

    @Autowired
    public void setDialogPrinter(@Qualifier("dialogPrinter") Printer dialogPrinter) {
        this.dialogPrinter = dialogPrinter;
    }


    @Autowired
    public void setSomePrinter(Printer somePrinter) {
        this.somePrinter = somePrinter;
    }

    public void sayHello() {
        if (new Random().nextInt(2) > 0) {
            consolePrinter.print("Hello, world!");
        }
        else {
            dialogPrinter.print("Hello, world!");
        }
    }



}
