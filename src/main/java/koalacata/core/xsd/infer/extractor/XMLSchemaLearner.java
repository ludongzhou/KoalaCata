package koalacata.core.xsd.infer.extractor;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
        BufferedReader stdInput;
        BufferedReader stdError;
        StringBuilder stringBuilder = new StringBuilder();

        // logger.info(System.getProperty("user.dir"));
        System.out.println(file.getAbsolutePath());
        ProcessBuilder processBuilder = new ProcessBuilder("lib/XML-Schema-learner/schema-learn", "-t", "xsd"
                , "--locality", "2", file.getAbsolutePath());
        // ProcessBuilder processBuilder = new ProcessBuilder("lib/XML-Schema-learner/schema-learn", "-t", "xsd",
        //         "--locality", "1", file.getAbsolutePath());
        try {
            Process process = processBuilder.start();

            stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            while ((line = stdInput.readLine()) != null) {
                stringBuilder.append(line);
            }
            stdInput.close();

            // BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            // BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            //
            // // read the output from the command
            // System.out.println("Here is the standard output of the command:\n");
            String out = null;
            // while ((out = stdInput.readLine()) != null) {
            //     System.out.println(out);
            // }
            //
            // // read any errors from the attempted command
            // System.out.println("Here is the standard error of the command (if any):\n");
            while ((out = stdError.readLine()) != null) {
                System.out.println(out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        docString = stringBuilder.toString();
        // logger.debug(docString);
    }

    public void extract(String xml) {
        ByteArrayInputStream stream = new ByteArrayInputStream(xml.getBytes());
        extract(stream);
    }

    @Override
    public String getXSD() {
        return docString;
    }
}
