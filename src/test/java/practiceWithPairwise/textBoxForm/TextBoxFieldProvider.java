package practiceWithPairwise.textBoxForm;

import com.abslab.lib.pairwise.gen.PairwiseGenerator;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static practiceWithPairwise.textBoxForm.TextBoxFormFields.*;

@Data
@Builder
@NoArgsConstructor
public class TextBoxFieldProvider {

    private static Map<String,List<Object>> params = new HashMap<>();


    public List<TextBoxFormModel> getTextBoxFieldsPairwaizerCases(){
        PairwiseGenerator<String, Object> gen = new PairwiseGenerator<>(params);
        List<Object> cases = gen.stream().collect(Collectors.toList());
        return cases.stream().map(testCase->getTextBoxModel((ArrayList<String>) testCase)).collect(Collectors.toList());

    }

    public TextBoxFieldProvider setParamsByFieldName(TextBoxFormFields fieldName, List<String> namesValues){
       params.put(
               fieldName.getField(),
               namesValues.stream()
                       .map(userName->format("%s=%s",fieldName.getField(),userName))
                       .collect(Collectors.toList())) ;
       return this;
    }

    private TextBoxFormModel getTextBoxModel(ArrayList<String> object){
        TextBoxFormModel model = new TextBoxFormModel();
        object.forEach(elem->{
            if (elem.contains(USER_NAME.getField())){
                model.setUserName(elem.replace(USER_NAME.getField()+"=",""));
            }
            if (elem.contains(USER_EMAIL.getField())){
                model.setUserEmail(elem.replace(USER_EMAIL.getField()+"=",""));
            }
            if (elem.contains(USER_CURRENT_ADDRESS.getField())){
                model.setCurrentAddress(elem.replace(USER_CURRENT_ADDRESS.getField()+"=",""));
            }
            if (elem.contains(USER_PERMANENT_ADDRESS.getField())){
                model.setPermanentAddress(elem.replace(USER_PERMANENT_ADDRESS.getField()+"=",""));
            }
        });
        return model;
    }
}
