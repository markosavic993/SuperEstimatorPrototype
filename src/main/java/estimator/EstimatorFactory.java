package estimator;

/**
 * Created by msav on 7/22/2017.
 */
public class EstimatorFactory {

    public static IEstimator createSuperEstimator() {
        return new SuperEstimator();
    }

    public static IEstimator createBasicEstimator() {
        return new BasicEstimator();
    }
}
