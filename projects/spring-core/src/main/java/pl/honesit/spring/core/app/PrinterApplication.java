package pl.honesit.spring.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.honesit.spring.core.components.printers.ConsolePrinter;
import pl.honesit.spring.core.components.printers.DialogPrinter;
import pl.honesit.spring.core.components.printers.FilePrinter;
import pl.honesit.spring.core.config.WarmUpConfiguration;



public class PrinterApplication {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WarmUpConfiguration.class);



        ConsolePrinter consolePrinter = context.getBean("consolePrinter",ConsolePrinter.class);
        consolePrinter.print("Hello console 1");

        DialogPrinter dialogPrinter = context.getBean("dialogPrinter", DialogPrinter.class);
        dialogPrinter.print("Hello dialog 1");

        FilePrinter filePrinter = context.getBean("filePrinter", FilePrinter.class);
        filePrinter.print("Hello file 1");

        ConsolePrinter consolePrinter2 = context.getBean(ConsolePrinter.class);
        consolePrinter2.print("Hello console 2");

        DialogPrinter dialogPrinter2 = context.getBean(DialogPrinter.class);
        dialogPrinter2.print("Hello dialog 2");

        FilePrinter filePrinter2 = context.getBean(FilePrinter.class);
        filePrinter2.print("Hello file 2");



    }
}
