package koalacata.metric;

import java.util.HashMap;

/**
 * Created by zhouludong on 2017/4/24.
 */
public class MetricMain {
    public static void main(String[] args) {
        Metric metric = new Metric();

        String sourceFilePath = "source_xml/youkuzongyi/";
        String resultFilePath = "result_xml/实验4/youkuzongyi/";
        String answerFilePath = "answer_xml/youkuzongyi/";

        HashMap<String, Double> result = metric.calc(sourceFilePath, answerFilePath, resultFilePath);

        for (String key: result.keySet()) {
            System.out.format("%-9s : %.04f\n", key, result.get(key));
        }
    }
}
