package estimator;

/**
 * Created by msav on 7/22/2017.
 */
class EstimatorFactory {

    static Estimator createSuperEstimator() {
        return new SuperEstimator();
    }

    static Estimator createBasicEstimator() {
        return new BasicEstimator();
    }
}
