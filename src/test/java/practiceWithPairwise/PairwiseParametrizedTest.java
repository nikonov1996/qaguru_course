package practiceWithPairwise;

import com.abslab.lib.pairwise.gen.PairwiseGenerator;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.pavelicii.allpairs4j.AllPairs;
import io.github.pavelicii.allpairs4j.Case;
import io.github.pavelicii.allpairs4j.Parameter;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import practiceWithPairwise.textBoxForm.TextBoxFieldProvider;
import practiceWithPairwise.textBoxForm.TextBoxFormModel;


import java.util.*;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static demoqa.service.RandomTestData.getFackerInctance;
import static practiceWithPairwise.textBoxForm.TextBoxFormFields.*;

public class PairwiseParametrizedTest {

    @BeforeAll
    static void before() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
//        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.baseUrl = "http://85.192.34.140:8081";
    }

    @ParameterizedTest
    @MethodSource("getTexBoxFieldsAllPairsParams")
    void fillTexBoxFieldsByAllPairs4j(Case testCase) {
        open("/");
        $(byTagAndText("h5", "Elements")).click();
        $("#item-0").click();
        $("#userName").setValue((String) testCase.get("userName"));
        $("#app #userEmail").setValue((String) testCase.get("userEmail"));
        $("#app #currentAddress").setValue((String) testCase.get("currentAddress"));
        $("#app #permanentAddress").setValue((String) testCase.get("permanentAddress"));
        $("#app #submit").click();
    }

    @ParameterizedTest
    @MethodSource("getTexBoxFieldsPairwiserParams")
    void fillTexBoxFieldsByPairwiser(TextBoxFormModel textBoxFieldModel) {
        System.out.println(textBoxFieldModel);
        System.out.println("\n\n********************");
        open("/");
        $(byTagAndText("h5", "Elements")).click();
        $("#item-0").click();
        $("#userName").setValue(textBoxFieldModel.getUserName());
        $("#app #userEmail").setValue(textBoxFieldModel.getUserEmail());
        $("#app #currentAddress").setValue(textBoxFieldModel.getCurrentAddress());
        $("#app #permanentAddress").setValue(textBoxFieldModel.getPermanentAddress());
        $("#app #submit").click();
    }

    private static List<Case> getTexBoxFieldsAllPairsParams() {
        var userNameList = List.of(
                getFackerInctance().name().lastName(),
                getFackerInctance().name().firstName(),
                getFackerInctance().name().fullName());
        var userEmailList = List.of(
                getFackerInctance().internet().emailAddress(),
                getFackerInctance().internet().safeEmailAddress()
        );
        var currentAddressList = List.of(
                getFackerInctance().address().fullAddress(),
                getFackerInctance().address().streetName(),
                getFackerInctance().address().secondaryAddress()
        );
        var permanentAddressList = List.of(
                getFackerInctance().address().fullAddress(),
                getFackerInctance().address().streetName(),
                getFackerInctance().address().secondaryAddress()
        );
        AllPairs allPairs = new AllPairs.AllPairsBuilder()
                .withParameters(Arrays.asList(
                        new Parameter("userName", userNameList),
                        new Parameter("userEmail", userEmailList),
                        new Parameter("currentAddress", currentAddressList),
                        new Parameter("permanentAddress", permanentAddressList)))
                .build();
        return allPairs.getGeneratedCases();
    }


        private static List<Object> getTexBoxFieldsPairwiserParamsSample() {
            Map<String, List<Object>> params = new HashMap<>();
            var userNameList = List.of(
                            getFackerInctance().name().lastName(),
                            getFackerInctance().name().firstName(),
                            getFackerInctance().name().fullName());
            var userEmailList = List.of(
                            getFackerInctance().internet().emailAddress(),
                            getFackerInctance().internet().safeEmailAddress());
            var currentAddressList = List.of(
                            getFackerInctance().address().fullAddress(),
                            getFackerInctance().address().streetName(),
                            getFackerInctance().address().secondaryAddress());
            var permanentAddressList = List.of(
                            getFackerInctance().address().fullAddress(),
                            getFackerInctance().address().streetName(),
                            getFackerInctance().address().secondaryAddress());

            params.put("userName", new ArrayList<>(userNameList));
            params.put("userEmail", new ArrayList<>(userEmailList));
            params.put("currentAddress", new ArrayList<>(currentAddressList));
            params.put("permanentAddress", new ArrayList<>(permanentAddressList));
            PairwiseGenerator<String, Object> gen = new PairwiseGenerator<>(params);
            return gen.stream().collect(Collectors.toList());
        }

    private static List<TextBoxFormModel> getTexBoxFieldsPairwiserParams() {

        return new TextBoxFieldProvider()
                .setParamsByFieldName(USER_NAME, List.of(
                        getFackerInctance().name().lastName(),
                        getFackerInctance().name().firstName(),
                        getFackerInctance().name().fullName()))
                .setParamsByFieldName(USER_EMAIL, List.of(
                        getFackerInctance().internet().emailAddress(),
                        getFackerInctance().internet().safeEmailAddress()
                ))
                .setParamsByFieldName(USER_CURRENT_ADDRESS, List.of(
                        getFackerInctance().address().fullAddress(),
                        getFackerInctance().address().streetName(),
                        getFackerInctance().address().secondaryAddress()
                ))
                .setParamsByFieldName(USER_PERMANENT_ADDRESS, List.of(
                        getFackerInctance().address().fullAddress(),
                        getFackerInctance().address().streetName(),
                        getFackerInctance().address().secondaryAddress()
                ))
                .getTextBoxFieldsPairwaizerCases();
    }

}

