package practiceWithFiles;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideFilesTest {

    @Test
    public void testSelenideDownloadFilesTest() throws IOException {
        //open("https://github.com/nikonov1996/qaguru_course/blob/master/src/test/resources/file.jpg");
        open("https://github.com/nikonov1996/qaguru_course/blob/master/README.md");
        // File это не сам файл, это абстракция над путями куда скачается файл
        File downloadFile = $("#raw-url").download();

        // Чтение файла по байтам:
        InputStream inputStream = new FileInputStream(downloadFile);
        byte[] bytes = inputStream.readAllBytes();
        // Если файл текстовый, то можем прочитать следующим образом:
        String string = new String(bytes, StandardCharsets.UTF_8);

        // Если тест упадет/ будет ошибка, то данная часть кода не сработает и файл не закроется!!! Эту проблему решает try catch finally.
        // В finally указать close и он выполнится в любом случае
        inputStream.close();
        System.out.println(string);

        // Так как InputStream реализует интерфейс Closable , то мы может использовать следующую конструкцию и не закрывать явно файл:
        open("https://github.com/nikonov1996/qaguru_course/blob/master/README.md");
        File downloadFile1 = $("#raw-url").download();
        try (InputStream inputStream1 = new FileInputStream(downloadFile1)){
            byte[] bytes1 = inputStream.readAllBytes();
            // Если файл текстовый, то можем прочитать следующим образом:
            String str = new String(bytes1, StandardCharsets.UTF_8);
        }


        // Если у кнопки для скачивания нет атрибута href, то используется PROXY сервер,который может задетектить файл:
        // Такая конструкция делает тесты нестабильными.
        /*
        static{
            Configuration.fileDownload = FileDownloadMode.PROXY;
        }
        */
    }

    @Test
    public void testSelenideUploadFilesTest(){

        // используемые тестами файлы должны быть в папке resources
        open("https://fineuploader.com/demos.html");
        // Это плохая практика, т.к. файлы должны быть в resources
//        $("input[type='file']").uploadFile(new File("путь к файлу"));
        $("input[type='file']").uploadFromClasspath("files/file.jpg");
        $(".qq-file-name").shouldBe(Condition.visible).shouldHave(Condition.text("file.jpg"));
    }
}
