package demoqa;

import demoqa.pages.TestBase;
import junit.data.Locale;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class CheckBoxesTest extends TestBase {

    /*
    Кейсы:
    1. проверить, что если выделить все файлы в папке то в списке выбранных появляется название папки
    2. проверить, что если выбрать папку, то выбираются все папки и файлы внутри
     */

    @Test
    public void testThatCheckedValueInSelectedList(){

        checkBoxPage
                .openPage()
                .expandAllCheckBoxes()
                .checkAllInFolder("Office");
    }

    @MethodSource("testThatIfCheckedFolderThenFilesInAlsoChecked")
    @ParameterizedTest
    public void testThatIfCheckedFolderThenFilesInAlsoChecked(
            String folderName,
            List<String> folderFiles
    ){

        checkBoxPage
                .openPage()
                .expandAllCheckBoxes()
                .checkAllInFolder(folderName)
                .verifyThatElementsCheckedByTitles(folderFiles)
                .verifyThatValuesInResultSelected(folderFiles);
    }



    static Stream<Arguments> testThatIfCheckedFolderThenFilesInAlsoChecked(){
        return Stream.of(
                Arguments.of(
                        "WorkSpace",
                        List.of("React", "Angular", "Veu")
                ),
                Arguments.of(
                        "Office",
                        List.of("Public", "Private", "Classified", "General")
                )
        );
    }


}
