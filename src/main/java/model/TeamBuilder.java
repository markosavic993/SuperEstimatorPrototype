package model;

import java.util.List;
import java.util.Map;

public class TeamBuilder {
    private String teamName = "DEFAULT_NAME";
    private int numberOfMembers;
    private TeamStructure structure;
    private List<Project> projects;
    private boolean distributed;
    private List<ScrumTools> scrumTools;
    private List<Technology> technologies;
    private List<Feature> knownFeatures;
    private Map<Stakeholder, StakeholderExperience> stakeholderExperienceMap;
    private int numberOfMembers1;
    private Map<Stakeholder, StakeholderExperience> stakeholderExperienceMap1;
    private List<String> familiarDomains;

    public TeamBuilder setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
        return this;
    }

    public TeamBuilder setStructure(TeamStructure structure) {
        this.structure = structure;
        return this;
    }

    public TeamBuilder setProjects(List<Project> projects) {
        this.projects = projects;
        return this;
    }

    public TeamBuilder setDistributed(boolean distributed) {
        this.distributed = distributed;
        return this;
    }

    public TeamBuilder setScrumTools(List<ScrumTools> scrumTools) {
        this.scrumTools = scrumTools;
        return this;
    }

    public TeamBuilder setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
        return this;
    }

    public TeamBuilder setKnownFeatures(List<Feature> knownFeatures) {
        this.knownFeatures = knownFeatures;
        return this;
    }

    public TeamBuilder setStakeholderExperienceMap(Map<Stakeholder, StakeholderExperience> stakeholderExperienceMap) {
        this.stakeholderExperienceMap = stakeholderExperienceMap;
        return this;
    }

    public TeamBuilder setFamiliarDomains(List<String> familiarDomains) {
        this.familiarDomains = familiarDomains;
        return this;
    }

    public TeamBuilder setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public Team createTeam() {
        return new Team(numberOfMembers, teamName, structure, projects, distributed, scrumTools, technologies, knownFeatures, stakeholderExperienceMap, numberOfMembers1, stakeholderExperienceMap1, familiarDomains);
    }
}