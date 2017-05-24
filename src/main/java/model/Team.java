package model;

import java.util.List;
import java.util.Map;

/**
 * Created by msav on 5/17/2017.
 */
public class Team {
    private int numberOfMembers;
    private TeamStructure structure;
    private List<Project> projects;
    private boolean distributed;
    private List<ScrumTools> scrumTools;
    private List<Technology> technologies;
    private List<Feature> knownFeatures;
    private Map<Stakeholder, StakeholderExperience> stakeholderExperienceMap;
    private List<String> familiarDomains;

    public Team() {
    }

    public Team(int numberOfMembers, TeamStructure structure, List<Project> projects, boolean distributed, List<ScrumTools> scrumTools, List<Technology> technologies, List<Feature> knownFeatures, Map<Stakeholder, StakeholderExperience> stakeholderExperienceMap, int numberOfMembers1, Map<Stakeholder, StakeholderExperience> stakeholderExperienceMap1, List<String> familiarDomains) {
        this.structure = structure;
        this.projects = projects;
        this.distributed = distributed;
        this.scrumTools = scrumTools;
        this.technologies = technologies;
        this.knownFeatures = knownFeatures;
        this.numberOfMembers = numberOfMembers1;
        this.stakeholderExperienceMap = stakeholderExperienceMap1;
        this.familiarDomains = familiarDomains;
    }

    public TeamStructure getStructure() {
        return structure;
    }

    public void setStructure(TeamStructure structure) {
        this.structure = structure;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public boolean isDistributed() {
        return distributed;
    }

    public void setDistributed(boolean distributed) {
        this.distributed = distributed;
    }

    public List<ScrumTools> getScrumTools() {
        return scrumTools;
    }

    public void setScrumTools(List<ScrumTools> scrumTools) {
        this.scrumTools = scrumTools;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }

    public List<Feature> getKnownFeatures() {
        return knownFeatures;
    }

    public void setKnownFeatures(List<Feature> knownFeatures) {
        this.knownFeatures = knownFeatures;
    }

    public Map<Stakeholder, StakeholderExperience> getStakeholderExperienceMap() {
        return stakeholderExperienceMap;
    }

    public void setStakeholderExperienceMap(Map<Stakeholder, StakeholderExperience> stakeholderExperienceMap) {
        this.stakeholderExperienceMap = stakeholderExperienceMap;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public List<String> getFamiliarDomains() {
        return familiarDomains;
    }

    public void setFamiliarDomains(List<String> familiarDomains) {
        this.familiarDomains = familiarDomains;
    }
}
