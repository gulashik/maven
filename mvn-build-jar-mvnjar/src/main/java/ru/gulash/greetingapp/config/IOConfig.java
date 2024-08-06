package ru.gulash.greetingapp.config;

import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.stereotype.Component;

import java.util.Locale;

@ToString
//@EnableConfigurationProperties(IOConfig.class)
@ConfigurationProperties(prefix = "gulash.custom")
public class IOConfig {

    @Getter
    private final boolean ioEnabled;
    private final Locale locale;

    @ConstructorBinding
    public IOConfig(boolean ioEnabled, String locale) {
        this.ioEnabled = ioEnabled;
        this.locale = Locale.forLanguageTag(locale);
    }

    public Locale getCurrent() {
        return locale;
    }
}
