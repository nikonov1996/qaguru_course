package practiceWithFiles.filesPracticeHomeWork.service.fileExtension;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static com.codeborne.selenide.Selenide.$;

public class PdfFile {
    public static PDF getPdfFileContent(File filename) throws IOException {
        return new PDF(filename);
    }

    public static PDF getPdfFileContent(ClassLoader classLoader, String filename) throws IOException {
        try (InputStream resourceStream = classLoader.getResourceAsStream(filename)) {
            return new PDF(resourceStream);
        }
    }

}