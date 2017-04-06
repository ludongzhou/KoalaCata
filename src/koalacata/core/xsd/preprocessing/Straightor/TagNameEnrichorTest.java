package koalacata.core.xsd.preprocessing.Straightor;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by zhouludong on 2017/4/6.
 */
@RunWith(Arquillian.class)
public class TagNameEnrichorTest {
    @Test
    public void run() throws Exception {
        System.out.println("hello world\n");
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(TagNameEnrichor.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
