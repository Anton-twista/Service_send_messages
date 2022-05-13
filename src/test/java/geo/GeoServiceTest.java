package geo;

import org.example.entity.Country;
import org.example.entity.Location;
import org.example.geo.GeoService;
import org.example.geo.GeoServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class GeoServiceTest {

    @Test
    public void ipNumber_test() {
        GeoService geoService = new GeoServiceImpl();
        Location expected = new Location("Moscow", Country.RUSSIA, null, 0);
        Location result = geoService.byIp("172. ");
        Assertions.assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void byIpName_test() {
        GeoService geoService = new GeoServiceImpl();
        Location expected = new Location("New York", Country.USA, "10th Avenue", 32);
        Location result = geoService.byIp(GeoServiceImpl.NEW_YORK_IP);
        Assertions.assertEquals(expected.toString(), result.toString());
    }
}