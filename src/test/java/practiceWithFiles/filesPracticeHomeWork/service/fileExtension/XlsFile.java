package practiceWithFiles.filesPracticeHomeWork.service.fileExtension;

import com.codeborne.xlstest.XLS;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class XlsFile {

    public static XLS getXlsFileContent(File filename){
        return new XLS(filename);
    }

    public static XLS getXlsFileContent(ClassLoader classLoader, String filename) throws IOException {
        try (InputStream resourceStream = classLoader.getResourceAsStream(filename)) {
            assert resourceStream != null;
            return new XLS(resourceStream);
        }
    }
}
