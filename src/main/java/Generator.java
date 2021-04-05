import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Generator {

    private Map<String, String> params;
    private File templateFile;

    public Generator(String path, Map<String, String> params) {
        templateFile = new File(path);
        this.params = params;
    }

    public void setTemplateFile(File templateFile) {
        this.templateFile = templateFile;
    }

    public File getTemplateFile() {
        return templateFile;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Map<String,String> getParams() {
        return this.params;
    }

    public File write() throws Exception {
        String name = templateFile.getName() + "_" +
                                           LocalDateTime.now().getDayOfMonth() + "_" +
                                           LocalDateTime.now().getMonthValue() + "_" +
                                           LocalDateTime.now().getYear() + "_" +
                                           LocalDateTime.now().getHour() + "_" +
                                           LocalDateTime.now().getMinute() + "_" +
                                           LocalDateTime.now().getSecond()+ ".docx";
        XWPFDocument result = generate(templateFile.getAbsolutePath());
        result.write(new FileOutputStream(name));
        System.out.println("Complete");
        return new File(name);
    }

    private XWPFDocument generate(String path) throws Exception {
        XWPFDocument document = new XWPFDocument(OPCPackage.open(templateFile));
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            for (XWPFRun run : paragraph.getRuns()) {
                String text = run.getText(0);
                if(text != null) {
                    if (params.get(text) != null) {
                        List<String> values = new ArrayList<>(params.keySet());
                        for (String value : values) {
                            if (text.equals(value)) {
                                text = text.replace(value, params.get(value));
                                run.setText(text,0);
                            }
                        }
                    }
                }
            }
        }
        return document;
    }

}
