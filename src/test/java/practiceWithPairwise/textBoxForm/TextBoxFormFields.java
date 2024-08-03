package practiceWithPairwise.textBoxForm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TextBoxFormFields {
    USER_NAME("userName"),
    USER_EMAIL("userEmail"),
    USER_CURRENT_ADDRESS("currentAddress"),
    USER_PERMANENT_ADDRESS("permanentAddress");

    private final String field;
}
