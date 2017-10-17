package estimator;

import rules.RuleType;

/**
 * Created by msav on 10/17/2017.
 */
public class EstimatorBuilder {

    private Estimator estimator;

    public EstimatorBuilder createEstimator() {
        estimator = EstimatorFactory.createBasicEstimator();
        return this;
    }

    public EstimatorBuilder withExplanation() {
        estimator = EstimatorFactory.createSuperEstimator();
        return this;
    }

    public EstimatorBuilder forProjectType(RuleType type) {
        if(estimator == null) {
            estimator = EstimatorFactory.createBasicEstimator();
        }
        estimator.setType(type);
        return this;
    }

    public Estimator build() {
        return estimator;
    }

}
