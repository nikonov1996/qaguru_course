package reqresin.helpers;

import io.qameta.allure.restassured.AllureRestAssured;

public class CustomAllureListener {

    private static final AllureRestAssured FILTER = new AllureRestAssured();

    public static AllureRestAssured withCustomTemplates() {
        FILTER.setRequestTemplate("allureReportApiTemplates/request.ftl");
        FILTER.setResponseTemplate("allureReportApiTemplates/response.ftl");
        return FILTER;
    }
}
