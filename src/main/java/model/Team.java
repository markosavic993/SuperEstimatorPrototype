package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by msav on 5/17/2017.
 */
public class Team {
    private String teamName;
    private int numberOfMembers;
    private TeamStructure structure;
    private List<Project> projects;
    private boolean distributed;
    private List<ScrumTools> scrumTools;
    private List<Technology> technologies;
    private List<Feature> knownFeatures;
    private Map<Stakeholder, StakeholderExperience> stakeholderExperienceMap;
    private List<String> familiarDomains;

    Team() {
    }

    Team(int numberOfMembers, String teamName, TeamStructure structure, List<Project> projects, boolean distributed, List<ScrumTools> scrumTools, List<Technology> technologies, List<Feature> knownFeatures, Map<Stakeholder, StakeholderExperience> stakeholderExperienceMap, List<String> familiarDomains) {
        this.numberOfMembers = numberOfMembers;
        this.stakeholderExperienceMap = stakeholderExperienceMap;
        this.teamName = teamName;
        this.structure = structure;
        this.projects = projects;
        this.distributed = distributed;
        this.scrumTools = scrumTools;
        this.technologies = technologies;
        this.knownFeatures = knownFeatures;
        this.familiarDomains = familiarDomains;
    }

    public TeamStructure getStructure() {
        return structure;
    }

    void setStructure(TeamStructure structure) {
        this.structure = structure;
    }

    public List<Project> getProjects() {
        return projects;
    }

    void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public boolean isDistributed() {
        return distributed;
    }

    void setDistributed(boolean distributed) {
        this.distributed = distributed;
    }

    public List<ScrumTools> getScrumTools() {
        return scrumTools;
    }

    void setScrumTools(List<ScrumTools> scrumTools) {
        this.scrumTools = scrumTools;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }

    public List<Feature> getKnownFeatures() {
        return knownFeatures;
    }

    void setKnownFeatures(List<Feature> knownFeatures) {
        this.knownFeatures = knownFeatures;
    }

    public Map<Stakeholder, StakeholderExperience> getStakeholderExperienceMap() {
        return stakeholderExperienceMap;
    }

    void setStakeholderExperienceMap(Map<Stakeholder, StakeholderExperience> stakeholderExperienceMap) {
        this.stakeholderExperienceMap = stakeholderExperienceMap;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public List<String> getFamiliarDomains() {
        return familiarDomains;
    }

    void setFamiliarDomains(List<String> familiarDomains) {
        this.familiarDomains = familiarDomains;
    }

    public String getTeamName() {
        return teamName;
    }

    void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Stakeholder> getStakeholdersList() {
        return new ArrayList<>(this.getStakeholderExperienceMap().keySet());
    }

    public boolean doesProjectContainsBadValuedStakeholder(List<Stakeholder> projectStakeholders) {
        return projectStakeholders
                .stream()
                .anyMatch(stakeholder -> this.getStakeholderExperienceMap().get(stakeholder) == StakeholderExperience.BAD);
    }
}
