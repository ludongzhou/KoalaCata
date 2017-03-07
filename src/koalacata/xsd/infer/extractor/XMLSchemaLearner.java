package koalacata.xsd.infer.extractor;

import java.io.*;
import java.util.Map;

/**
 * Created by zhouludong on 2017/3/6.
 */
public class XMLSchemaLearner extends AbstractExtractor{
    private String docString;
    @Override
    public void extract(InputStream inputStream) {
    }

    @Override
    public void extract(File file) {
        String line;
        BufferedReader bufferedReader;
        StringBuilder stringBuilder = new StringBuilder();
        logger.info(System.getProperty("user.dir"));
        ProcessBuilder processBuilder = new ProcessBuilder("lib/XML-Schema-learner/schema-learn", "-t", "xsd",
                "--locality", "1", file.getAbsolutePath());
//        Map<String, String> env = pb.environment();
//        env.put("VAR1", "myValue");
//        env.remove("OTHERVAR");
//        env.put("VAR2", env.get("VAR1") + "suffix");
//        pb.directory(new File("myDir"));
        try {
            Process process = processBuilder.start();
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        docString = stringBuilder.toString();
    }

    @Override
    public String toString() {
        return docString;
    }
}
