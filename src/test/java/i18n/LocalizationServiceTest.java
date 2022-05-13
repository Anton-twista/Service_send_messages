package i18n;

import org.example.entity.Country;
import org.example.i18n.LocalizationService;
import org.example.i18n.LocalizationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LocalizationServiceTest {

    LocalizationService localizationService;

    @Before
    public void init_test() {
        localizationService = new LocalizationServiceImpl();
    }

    @Test

    public void local_RUSSIA_test() {

        String result = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals(result, "Добро пожаловать");
    }

    @Test

    public void local_USA_test() {

        String result = localizationService.locale(Country.USA);
        Assertions.assertEquals(result, "Welcome");
    }


}
