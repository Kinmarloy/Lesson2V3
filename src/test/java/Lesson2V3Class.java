
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Lesson2V3Class {

    String firstName = "Petrov",
            lastName = "Petr",
            userEmail = "petr@prtr.tu",
            gender = "Female", //Male , Other
            userNumber = "0123456789",
            dateOfBirthDay = "7",
            dateOfBirthMonth = "September",
            dateOfBirthYear = "1990",
            subjects1 = "Maths",
            subjects2 = "Arts",
            subjects3 = "English",
            hobbies1 = "Sports",
            hobbies2 = "Reading",
            hobbies3 = "Music",
            picture = "1.jpg",
            currentAddress = "Gomel",
            state = "Haryana",
            city = "Panipat";

    @Test
    void RegistrastionForm(){
        //открыть сайт
        open("https://demoqa.com/automation-practice-form");

        //проверить, что именно форма "Practice Form"
        $x("//div[text()='Practice Form']").shouldHave(text("Practice Form"));

        //Вводим данные
        $x("//input[@id='firstName']").setValue(firstName);
        $x("//input[@id='lastName']").setValue(lastName);
        $x("//input[@id='userEmail']").setValue(userEmail);
        $x("//input[@id='gender-radio-1']/following::label[text()='"+gender+"']").click();
        $x("//input[@id='userNumber']").setValue(userNumber);

        //календарь
        $x("//input[@id='dateOfBirthInput']").click();
        $x("//select[@class='react-datepicker__year-select']").selectOption(dateOfBirthYear);
        $x("//select[@class='react-datepicker__month-select']").selectOption(dateOfBirthMonth);
        if (dateOfBirthDay.length() == 1) dateOfBirthDay = "0" + dateOfBirthDay;
        $x("//div[contains(@class,'react-datepicker__day--0"+dateOfBirthDay+"')]").click();

        //Subjects
        $x("//input[@id='subjectsInput']").setValue(subjects1).pressEnter();
        $x("//input[@id='subjectsInput']").setValue(subjects2).pressEnter();
        $x("//input[@id='subjectsInput']").setValue(subjects3).pressEnter();

        //Hobbies
        $x("//div[@id='hobbiesWrapper']//label[text()='"+hobbies1+"']").click();
        $x("//div[@id='hobbiesWrapper']//label[text()='"+hobbies2+"']").click();
        $x("//div[@id='hobbiesWrapper']//label[text()='"+hobbies3+"']").click();

        //Загрузка изображения
        $x("//input[@id='uploadPicture']").uploadFromClasspath("img/"+picture);

        //Curent Address
        $x("//textarea[@id='currentAddress']").setValue(currentAddress);

        //State and City
        $x("//div[@id='state']").click();
        $x("//div[text()='" + state + "']").click();
        $x("//div[@id='city']").click();
        $x("//div[text()='" + city + "']").click();

        //Сохранить форму
        $x("//button[@id='submit']").click();

        //Проверить вывод результатов
        $x("//div[@id='example-modal-sizes-title-lg']").shouldHave(text("Thanks for submitting the form"));

        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(userEmail));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(userNumber));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dateOfBirthDay + " " + dateOfBirthMonth + "," + dateOfBirthYear));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subjects1 + ", " + subjects2 + ", " + subjects3));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobbies1 + ", " + hobbies2 + ", " + hobbies3));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));





        sleep(3000);
    }



}
