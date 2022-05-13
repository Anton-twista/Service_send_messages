package org.example.i18n;

import org.example.entity.Country;

public class LocalizationServiceImpl implements LocalizationService {

@Override
    public String locale(Country country) {
        switch (country) {
            case RUSSIA:
                return "Добро пожаловать";
            default:
                return "Welcome";
        }
    }

}
