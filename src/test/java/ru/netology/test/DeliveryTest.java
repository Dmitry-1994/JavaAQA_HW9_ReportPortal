package ru.netology.test;

import com.epam.reportportal.junit5.ReportPortalExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;
import ru.netology.data.DataGenerator;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static ru.netology.util.Util.logInfo;

@ExtendWith(ReportPortalExtension.class)
public class DeliveryTest {

    @BeforeEach
    void startSetup() {
        open("http://localhost:9999");
    }

    @Test
    void happyCase() {
        String firstRegistrationDay = DataGenerator.generateDate(5, "dd.MM.yyyy");
        String secondRegistrationDay = DataGenerator.generateDate(10, "dd.MM.yyyy");
        DataGenerator.UserInfo user = DataGenerator.Registration.generateUser("ru");
        $("[data-test-id=city] input").setValue(user.getCity());
        logInfo("enter city " + user.getCity());
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.DELETE);
        $("[data-test-id=date] input").setValue(firstRegistrationDay);
        logInfo("enter data " + firstRegistrationDay);
        $("[data-test-id=name] input").setValue(user.getName());
        logInfo("enter name " + user.getName());
        $("[data-test-id=phone] input").setValue(user.getPhone());
        logInfo("enter phone " + user.getPhone());
        $("[data-test-id=agreement] .checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id=success-notification]").shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id=success-notification] .notification__title").shouldHave(text("Успешно!"));
        $("[data-test-id=success-notification] .notification__content").shouldHave(text("Встреча успешно запланирована на " + firstRegistrationDay));
        $("[data-test-id=success-notification] .icon-button").click();
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.DELETE);
        $("[data-test-id=date] input").setValue(secondRegistrationDay);
        $(".button__text").click();
        $("[data-test-id=replan-notification]").shouldBe(visible);
        $("[data-test-id=replan-notification] .notification__title").shouldHave(text("Необходимо подтверждение"));
        $("[data-test-id=replan-notification] .notification__content").shouldHave(text("У вас уже запланирована встреча на другую дату. Перепланировать?"));
        $("[data-test-id=replan-notification] .button__content").click();
        $("[data-test-id=success-notification]").shouldBe(visible);
        $("[data-test-id=success-notification] .notification__title").shouldHave(text("Успешно!"));
        $("[data-test-id=success-notification] .notification__content").shouldHave(text("Встреча успешно запланирована на " + secondRegistrationDay));
        logInfo("test completed successfully");
    }
}
