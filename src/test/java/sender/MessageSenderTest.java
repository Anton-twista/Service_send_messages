package sender;

import org.example.entity.Country;
import org.example.entity.Location;

import org.example.geo.GeoService;
import org.example.i18n.LocalizationService;
import org.example.sender.MessageSender;
import org.example.sender.MessageSenderImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTest {

    @Test
    public void messageSenderTest() {

        String ip = "172.0.32.11";
        String message = "Добро пожаловать";


        Location location;
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(ip))
                .thenReturn(location = new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(location.getCountry())).thenReturn(message);
        MessageSender messageSenderImpl = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> map = new HashMap<>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);
        String messageSender = messageSenderImpl.send(map);
        String expected = localizationService.locale(Country.RUSSIA);
        Assertions.assertEquals(expected, messageSender);


    }

    @Test
    public void sendMessageUSA_test() {


    }


}
