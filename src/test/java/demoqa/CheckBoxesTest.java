package demoqa;

import demoqa.pages.TestBase;
import junit.data.Locale;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class CheckBoxesTest extends TestBase {


    @ValueSource(
            strings = {
                    "React", "Angular", "Veu","Public", "Private", "Classified", "General", "Home", "Downloads"
            }
    )
    @ParameterizedTest
    public void testThatCheckedValueInSelectedResultList(String title){

        checkBoxPage
                .openPage()
                .expandAllCheckBoxes()
                .checkByTitle(title)
                .verifyThatValueInResultSelected(title);
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
                .checkByTitle(folderName)
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
