package practiceWithFiles.filesPracticeHomeWork.service.fileExtension;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static java.lang.String.format;

public class ZipFile {

    public static void unzipFileByName(ClassLoader classLoader, String zipPath, String fileName) throws IOException {
        String pathToUnzip = format("./src/test/resources/zip/%s",fileName);
        try (
                InputStream resourceStream = classLoader.getResourceAsStream(zipPath);
                ZipInputStream zipInputStream = new ZipInputStream(resourceStream)
        ) {
                ZipEntry entry;
                while ((entry = zipInputStream.getNextEntry()) != null){
                        String currentFileName = entry.getName();
                        if(currentFileName.contains(fileName)) {
                            try(FileOutputStream fout = new FileOutputStream( pathToUnzip)){
                            fout.write(zipInputStream.readAllBytes());
                            fout.flush();
                            }
                        }
                }
        }
    }

}
