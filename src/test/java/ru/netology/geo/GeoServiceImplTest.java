package ru.netology.geo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceImplTest {
    @Test
    public void IsLocalhostEqualsIp1() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Assertions.assertEquals( new Location(null, null, null, 0),geoService.byIp("127.0.0.1"));
    }
   @Test
   public void IsLocalhostEqualsIp2() {
       GeoServiceImpl geoService = new GeoServiceImpl();
       Assertions.assertEquals( new Location("Moscow", Country.RUSSIA, "Lenina", 15),geoService.byIp("172.0.32.11"));
   }
    @Test
    public void IsLocalhostEqualsIp3() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Assertions.assertEquals( new Location("New York", Country.USA, " 10th Avenue", 32),geoService.byIp("96.44.183.149"));
    }
    @Test
    public void IsLocalhostEqualsIp4() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Assertions.assertEquals(new Location("Moscow", Country.RUSSIA, null, 0),geoService.byIp("172.0.32.12"));
    }
    @Test
    public void IsLocalhostEqualsIp5() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Assertions.assertEquals(new Location("New York", Country.USA, " 10th Avenue", 32),geoService.byIp("96.44.183.333"));
    }
}

