package ru.gulash.greetingapp.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.gulash.greetingapp.config.IOConfig;
import ru.gulash.greetingapp.services.IOService;
import ru.gulash.greetingapp.services.LocalizationService;

import static java.util.Objects.isNull;

@Component
public class AppRunner implements ApplicationRunner {

    private final IOConfig ioConfig;
    private final IOService ioService;
    private final LocalizationService localizationService;

    public AppRunner(
            IOConfig ioConfig,
            IOService ioService,
            LocalizationService localizationService
    ) {
        this.ioConfig = ioConfig;
        this.ioService = ioService;
        this.localizationService = localizationService;
    }


    @Override
    public void run(ApplicationArguments args) {
        if (isNull(ioService)) {
            System.err.println("Отсутствует сервис ввода-вывода. Включите настройку \"gulash.custom.io.enabled\"");
            return;
        }
        ioService.outputString("---------------------------------------------");

        ioService.outputAsString(ioConfig);

        ioService.outputString("---------------------------------------------");

        var greetingTarget = localizationService.getMessage("greeting.target");
        var greeting = localizationService.getMessage("greeting", greetingTarget);
        ioService.outputString(greeting);

        ioService.outputString("---------------------------------------------");
    }
}
