package practiceWithFiles.filesPracticeHomeWork.service.fileExtension;

import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CsvFile {

    public static List<String[]> getCsvFileContent(ClassLoader classLoader, String filename) throws IOException, CsvException {
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(classLoader.getResourceAsStream(filename))
        ) {
            return new CSVReader(inputStreamReader).readAll();
        }
    }
}