package koalacata.xsd.transfer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhouludong on 2017/3/15.
 */
public class Transfer {
    public String start() {
        String xslFolder = "xslt/result";
        String xmlPath = "sample/2.xml";
        try {
            Process process = Runtime.getRuntime().exec(
                    "python3 lib/XMLFormator/scripts/Formatter/XMLFormatter.py "
                            + xmlPath + " " + xslFolder + " result");
            process.waitFor();

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            String out = null;
            while ((out = stdInput.readLine()) != null) {
                System.out.println(out);
            }

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((out = stdError.readLine()) != null) {
                System.out.println(out);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Transfer transfer = new Transfer();
        transfer.start();
    }
}
