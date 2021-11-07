package selflearning.CDILearning;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class MainClass {

    @Inject
    public @Named("AnotherImpl")SimpleServiceInterface simpleServiceInterface;

    public void call(String from){
        simpleServiceInterface.getServiceResult1(from);
    }

    public static void main(String[] args) {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

       MainClass mainClass = container.select(MainClass.class).get();
       mainClass.call("main");
       container.shutdown();

    }
}
