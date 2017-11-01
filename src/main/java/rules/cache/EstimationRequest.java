package rules.cache;

import model.Project;
import model.Team;

import java.util.Objects;

/**
 * Created by msav on 11/1/2017.
 */
public class EstimationRequest {

    private Team requestTeam;
    private Project requestProject;

    public EstimationRequest(Team requestTeam, Project requestProject) {
        this.requestTeam = requestTeam;
        this.requestProject = requestProject;
    }

    public Team getRequestTeam() {
        return requestTeam;
    }

    public Project getRequestProject() {
        return requestProject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstimationRequest that = (EstimationRequest) o;
        return Objects.equals(getRequestTeam(), that.getRequestTeam()) &&
                Objects.equals(getRequestProject(), that.getRequestProject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequestTeam(), getRequestProject());
    }
}
