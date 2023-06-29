package practiceWithFiles.filesPracticeHomeWork;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import practiceWithFiles.pojo.WidgetPojo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class getJsonWithDifferentLibTest {
    ClassLoader classLoader = getFilesTest.class.getClassLoader();

    @Test
    public void getJsonWithJackson() throws IOException {
        WidgetPojo widgetPojo = new ObjectMapper().readValue(
                classLoader.getResourceAsStream("files/test.json"),
                WidgetPojo.class
        );

        System.out.println(widgetPojo.widget.debug);
        System.out.println(Arrays.toString(widgetPojo.widget.images));
        System.out.println(Arrays.toString(widgetPojo.widget.pictures));
    }

    @Test
    public void getJsonWithGson() throws IOException {
        WidgetPojo widgetPojo = new Gson().fromJson(
                new InputStreamReader(classLoader.getResourceAsStream("files/test.json")),
                WidgetPojo.class
        );

        System.out.println(widgetPojo.widget.debug);
        System.out.println(Arrays.toString(widgetPojo.widget.images));
        System.out.println(Arrays.toString(widgetPojo.widget.pictures));
    }

}
