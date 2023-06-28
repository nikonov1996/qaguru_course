package practiceWithFiles.filesPracticeHomeWork.service.fileExtension;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;

import static practiceWithFiles.filesPracticeHomeWork.service.fileExtension.CsvFile.getCsvFileContent;
import static practiceWithFiles.filesPracticeHomeWork.service.fileExtension.PdfFile.getPdfFileContent;
import static practiceWithFiles.filesPracticeHomeWork.service.fileExtension.XlsFile.getXlsFileContent;

public class ResourceFileFactory {

    public static Object getResourceFileContent(ClassLoader classLoader, String filename) throws IOException, CsvException {
        String currentExtension = getFileExtension(filename.toLowerCase());
        if (currentExtension.contains("xls") || currentExtension.contains("xlsx")){
            return getXlsFileContent(classLoader,filename);
        } else if (currentExtension.contains("csv")){
            return getCsvFileContent(classLoader,filename);
        } else if (currentExtension.contains("pdf")){
            return getPdfFileContent(classLoader,filename);
        } else {
            throw new IOException("Incorrect file extension");
        }
    }

    private static String getFileExtension(String filename){
        String[] filenameSplits = filename.split(".");
        return filenameSplits[filenameSplits.length-1];
    }
}
