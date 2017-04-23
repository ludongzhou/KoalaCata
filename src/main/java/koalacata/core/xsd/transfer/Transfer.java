package koalacata.core.xsd.transfer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhouludong on 2017/3/15.
 */
public class Transfer {
    private Logger logger = LogManager.getLogger();

    public String start(String xmlPath, String dstFolder) {
        String xslFolder = "tmp/XSLT";
        try {
            String[] cmds = new String[5];

            // set command and args
            cmds[0] = "python3";
            cmds[1] = "lib/XMLFormator/scripts/Formatter/XMLFormatter.py";
            cmds[2] = xmlPath;
            cmds[3] = xslFolder;
            cmds[4] = dstFolder;

            Process process = Runtime.getRuntime().exec(cmds);
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
}
