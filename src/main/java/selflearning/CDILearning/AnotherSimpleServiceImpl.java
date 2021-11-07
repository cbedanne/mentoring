package selflearning.CDILearning;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("AnotherImpl")
public class AnotherSimpleServiceImpl implements SimpleServiceInterface{
    @Override
    public void getServiceResult1(String calledFrom) {
        System.out.println(this.getClass().getName() + " from " + calledFrom );
    }
}
