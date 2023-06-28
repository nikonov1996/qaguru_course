package practiceWithFiles.filesPracticeHomeWork;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static practiceWithFiles.filesPracticeHomeWork.service.fileExtension.CsvFile.getCsvFileContent;
import static practiceWithFiles.filesPracticeHomeWork.service.fileExtension.PdfFile.getPdfFileContent;
import static practiceWithFiles.filesPracticeHomeWork.service.fileExtension.ResourceFileFactory.getResourceFileContent;
import static practiceWithFiles.filesPracticeHomeWork.service.fileExtension.XlsFile.getXlsFileContent;
import static practiceWithFiles.filesPracticeHomeWork.service.fileExtension.ZipFile.unzipFileByName;

public class getFilesTest {

    ClassLoader classLoader = getFilesTest.class.getClassLoader();

    @Test
    void xlsResourceFileTest() throws IOException {

        XLS content = getXlsFileContent(classLoader,"files/test.xls");
        System.out.println(content.excel.getSheetAt(0));
    }

    @Test
    void xlsDownloadedFileTest() throws IOException {
        open("https://pervcrb.ru/kratkaya-istoricheskaya-spravka/informaciya-o-zarabotnoj-plate/");
        File downloadedXls = $("[href='http://pervcrb.ru/wp-content/uploads/docs/Приложение по ЗАМам  2021.xlsx']").download();
        XLS content = getXlsFileContent(downloadedXls);
        System.out.println(content.excel.getSheetAt(0));
    }

    @Test
    void csvResourceFileTest() throws IOException, CsvException {

         List<String[]> content = getCsvFileContent(classLoader,"files/test.csv");
        System.out.println(Arrays.toString(content.get(0)));
    }

    @Test
    void pdfResourceFileTest() throws IOException {

        PDF content = getPdfFileContent(classLoader,"files/test.pdf");
        System.out.println(content.text);
    }

    @Test
    void pdfResourceFileTestWithFactory() throws IOException, CsvException {

        PDF content = (PDF) getResourceFileContent(classLoader,"files/test.pdf");
        System.out.println(content.text);
    }

    @Test
    void testFilesFromZip() throws IOException, CsvException {
        String pdfFilename = "test.pdf";
        String csvFilename = "test.csv";
        String xlsFilename = "test.xls";
        unzipFileByName(classLoader,"zip/test_files.zip",pdfFilename);
        unzipFileByName(classLoader,"zip/test_files.zip",csvFilename);
        unzipFileByName(classLoader,"zip/test_files.zip",xlsFilename);

        PDF pdfContent = getPdfFileContent(classLoader,"zip/" + pdfFilename);
        System.out.println(pdfContent.text);

        List<String[]> csvContent = getCsvFileContent(classLoader,"zip/" + csvFilename);
        System.out.println(Arrays.toString(csvContent.get(0)));

        XLS xlsContent = getXlsFileContent(classLoader,"zip/" + xlsFilename);
        System.out.println(xlsContent.excel.getSheetAt(0));
    }

}
