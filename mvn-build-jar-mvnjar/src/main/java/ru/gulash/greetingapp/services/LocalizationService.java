package ru.gulash.greetingapp.services;

public interface LocalizationService {
    String getMessage(String key, Object ...args);
}
