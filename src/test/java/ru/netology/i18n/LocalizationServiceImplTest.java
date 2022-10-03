package ru.netology.i18n;
import org.junit.Assert;
import org.junit.Test;
import ru.netology.entity.Country;

public class LocalizationServiceImplTest  {
    @Test
    public void shouldReturnRuss() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        Assert.assertEquals("Добро пожаловать",localizationService.locale(Country.RUSSIA));
    }
    @Test
    public void shouldReturnEngl() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        Assert.assertEquals("Welcome",localizationService.locale(Country.USA));
    }
}
