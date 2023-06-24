package practiceWithFiles.pojo;

import com.google.gson.annotations.SerializedName;

public class WidgetPojo {
   public Widget widget;

    public static class Widget{
        public String debug;
        public Window window;
        public Image image;


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
            @SerializedName("Alignment")
            public String alignment;
        }
    }
}
