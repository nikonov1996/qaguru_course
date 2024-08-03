package practiceWithPairwise.textBoxForm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TextBoxFormModel {
    String userName;
    String userEmail;
    String currentAddress;
    String permanentAddress;
}
