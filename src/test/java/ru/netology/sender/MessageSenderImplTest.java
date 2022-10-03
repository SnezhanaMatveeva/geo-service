package ru.netology.sender;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTest {
    @Mock
    private GeoService geoService;
    @Mock
    private LocalizationService localizationService;
    private Map<String, String> headers = new HashMap<String, String>();

    @Before
    public void init() {
        geoService = Mockito.mock(GeoService.class);
        localizationService = Mockito.mock(LocalizationService.class);
    }

    @Test
    public void shouldReturnRussianTextIfIPisRussian() {
        headers.put("x-real-ip", "172.123.12.19");
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        Mockito.when(geoService.byIp("172.123.12.19")).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Assert.assertEquals(messageSender.send(headers), "Добро пожаловать");
    }

    @Test
    public void shouldReturnEnglishTextIfIPisEnglish() {
        headers.put("x-real-ip", "96.44.183.149");
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        Mockito.when(geoService.byIp("96.44.183.149")).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Assert.assertEquals(messageSender.send(headers),"Welcome");
    }

}
