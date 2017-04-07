package koalacata.core.xsd.mapping.matcher;

import de.wdilab.coma.integration.COMA_API;
import de.wdilab.coma.structure.MatchResult;

import java.io.File;

/**
 * Created by zhouludong on 2017/3/14.
 */
public class ComaMatcher extends AbstractMatcher {
    private MatchResult matchResult;
    public ComaMatcher(File source, File target) {
        this.sourceFile = source;
        this.targetFile = target;
    }

    public ComaMatcher() {}

    @Override
    public void match() {
        COMA_API coma_api = new COMA_API();
        matchResult = coma_api.matchModelsDefault(sourceFile.toString(), targetFile.toString(),
                "resource/acronym.dict", "resource/thesaurus.dict");
    }

    public void match(File source, File target) {
        this.sourceFile = source;
        this.targetFile = target;
        this.match();
    }

    public void match(String sourcePath, String targetPath) {
        this.match(new File(sourcePath), new File(targetPath));
    }

    @Override
    public String getCorrespondence() {
        return matchResult.toString();
    }
}
