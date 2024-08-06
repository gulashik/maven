package ru.gulash.greetingapp.config;

import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class DefaultLocaleProvider implements LocaleProvider {

    private final Locale locale;

    public DefaultLocaleProvider() {
        this.locale = Locale.forLanguageTag("ru-RUS");
    }

    @Override
    public Locale getCurrent() {
        return locale;
    }
}
