package koalacata.xsd.mapping.matcher;

import de.wdilab.coma.integration.COMA_API;
import de.wdilab.coma.structure.MatchResult;

import java.io.File;

/**
 * Created by zhouludong on 2017/3/14.
 */
public class ComaMatcher extends AbstractMacher {
    private MatchResult matchResult;
    public ComaMatcher(File source, File target) {
        this.sourceFile = source;
        this.targetFile = target;
    }

    @Override
    public void match() {
        COMA_API coma_api = new COMA_API();
        matchResult = coma_api.matchModelsDefault(sourceFile.toString(), targetFile.toString());
    }

    @Override
    public String getCorrespondence() {
        return matchResult.toString();
    }
}
