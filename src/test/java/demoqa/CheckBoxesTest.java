package demoqa;

import demoqa.pages.TestBase;
import io.qameta.allure.*;
import junit.data.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
@Feature("Форма /checkbox")
@Story("Заполнение формы /checkbox")
@Links(value = {
        @Link(name = "/checkbox", url = "https://demoqa.com/checkbox"),
        @Link(name = "base page", url = "https://demoqa.com")
})
public class CheckBoxesTest extends TestBase {


    @ValueSource(
            strings = {
                    "React", "Angular", "Veu","Public", "Private", "Classified", "General", "Home", "Downloads"
            }
    )
    @ParameterizedTest
    @Owner("Никонов В.А. @qanva")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверить, что выбранное значение отображается в списке результатов")
    public void testThatCheckedValueInSelectedResultList(String title){

        checkBoxPage
                .openPage()
                .expandAllCheckBoxes()
                .checkByTitle(title)
                .verifyThatValueInResultSelected(title);
    }
    @Owner("Никонов В.А. @qanva")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверить, что если выбран чекбокс директории, то файлы и папки внутри тоже выбраны")
    @MethodSource("getFolderAndFilesInTestData")
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
    @Owner("Никонов В.А. @qanva")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверить, что если выбраны все файлы/папки внутри директории, то чекбокс директории также выбран")
    @MethodSource("getFolderAndFilesInTestData")
    @ParameterizedTest
    public void testThatIfCheckedAllFilesThenFolderAlsoChecked(
            String folderName,
            List<String> folderFiles
    ){

        checkBoxPage
                .openPage()
                .expandAllCheckBoxes()
                .verifyThatUncheckedByTitle(folderName)
                .checkByTitlesInList(folderFiles)
                .verifyThatElementsCheckedByTitles(folderFiles)
                .verifyThatCheckedByTitle(folderName)
                .verifyThatValueInResultSelected(folderName)
                .verifyThatValuesInResultSelected(folderFiles);
    }


    static Stream<Arguments> getFolderAndFilesInTestData(){
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
