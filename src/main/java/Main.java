import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,String> params = new HashMap<>();
        params.put("idFirstName", "С.В. Барышников");
        params.put("idSecondName", "А.Ю. Милинский");
        params.put("idThirdName", "А.С. Матевосян");
        params.put("idState", "Плачевное");
        params.put("idOsName", "Windows 98");
        params.put("idNumber", "3301234565");
        params.put("idConclusion", "Всё плохо");
        params.put("idFirstNamePadeg", "С.В. Барышниковым");
        params.put("idSecondNamePadeg", "А.Ю. Милинским");
        params.put("idThirdNamePadeg", "А.С. Матевосян");

        Generator generator = new Generator("Template.docx", params);
        generator.setParams(params);
        try {
            generator.write();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
