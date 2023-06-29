package practiceWithFiles.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class WidgetPojo {
   public Widget widget;

    public static class Widget{
        public String debug;
        public Window window;
        public Image[] images;

        public String[] pictures;


        public static class Window{
            public String title;
            public String name;
            public Integer width;
            public Integer height;
        }

        public static class Image{
            public String src;
            public String name;
            public Integer hOffset;
            public Integer vOffset;

            @JsonProperty("Alignment")
            @SerializedName("Alignment")
            public String alignment;

            @Override
            public String toString() {
                return "Image{" +
                        "src='" + src + '\'' +
                        ", name='" + name + '\'' +
                        ", hOffset=" + hOffset +
                        ", vOffset=" + vOffset +
                        ", alignment='" + alignment + '\'' +
                        '}';
            }
        }
    }
}
