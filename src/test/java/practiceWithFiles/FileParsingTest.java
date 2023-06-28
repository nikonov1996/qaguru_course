package practiceWithFiles;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;
import practiceWithFiles.pojo.WidgetPojo;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class FileParsingTest {


    ClassLoader classLoader = FileParsingTest.class.getClassLoader();

    @Test
    public void pdfFileTest() throws IOException {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File downloadedPDF = $("a[href='junit-user-guide-5.9.3.pdf']").download();
        /* // Можно прочитать таким образом:
        try (InputStream inputStream = new FileInputStream(downloadedPDF);) {
           String pdfText = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            System.out.println(pdfText);
        } */

        // В selenide есть класс для этого:
        PDF content = new PDF(downloadedPDF);
        assertThat(content.author).contains("Sam Brannen");
        System.out.println(content.text);
    }



    @Test
    void xlsFileTest() throws IOException {
        // Если берем файл из ресурсов,то:
//        try (InputStream inputStream = classLoader.getResourceAsStream("files/test.xls")){
//            XLS content = new XLS(inputStream);
//            System.out.println(content.excel.getSheetAt(0).getRow(1).getCell(0).getStringCellValue());
//            //System.out.println(content.excel.getSheetAt(1).getRow(1).getCell(0).getStringCellValue());
//        }

        // Если скачиваем с сайта, то:
        open("https://pervcrb.ru/kratkaya-istoricheskaya-spravka/informaciya-o-zarabotnoj-plate/");
        File downloadedXls = $("[href='http://pervcrb.ru/wp-content/uploads/docs/Приложение по ЗАМам  2021.xlsx']").download();
        XLS content = new XLS(downloadedXls);
        System.out.println(content.excel.getSheetAt(0));
    }

    @Test
    void csvFileTest() throws IOException, CsvException {
        try (

                InputStream resourceStream = classLoader.getResourceAsStream("files/test.csv");
                CSVReader reader = new CSVReader(new InputStreamReader(resourceStream));

            ){
            List<String[]> content = reader.readAll();
            System.out.println(Arrays.toString(content.get(0)));
        }
    }

    @Test
    void zipFileTest() throws IOException {
        try (
                InputStream resourceStream = classLoader.getResourceAsStream("files/file.zip");
                ZipInputStream zipInputStream = new ZipInputStream(resourceStream);
        ){
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null){
                System.out.println(entry.getSize());
            }
        }
    }

    @Test
    void jsonFileTest() throws IOException {
        Gson gson = new Gson();
        try (
                InputStream resourceStream = classLoader.getResourceAsStream("files/test.json");
                InputStreamReader reader = new InputStreamReader(resourceStream);
        ){
            JsonObject jsonObject= gson.fromJson(reader, JsonObject.class);
            System.out.println(jsonObject.getAsJsonObject("widget").getAsJsonObject("window").get("title"));
        }

    }
// Проще использовать Gson если описать json объек как pojo класс:
    @Test
    void jsonFileImprovedTest() throws IOException {
        Gson gson = new Gson();
        try (
                InputStream resourceStream = classLoader.getResourceAsStream("files/test.json");
                InputStreamReader reader = new InputStreamReader(resourceStream);
        ){
            WidgetPojo widgetPojo= gson.fromJson(reader, WidgetPojo.class);
            System.out.println(widgetPojo.widget.debug);
            System.out.println(widgetPojo.widget.window.name);
            System.out.println(widgetPojo.widget.window.title);
            System.out.println(widgetPojo.widget.window.height);
            System.out.println(widgetPojo.widget.image.alignment);
            System.out.println(widgetPojo.widget.image.name);
            System.out.println(widgetPojo.widget.image.src);
            System.out.println(widgetPojo.widget.image.vOffset);
        }

    }
}




