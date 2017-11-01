package model;

import java.util.List;
import java.util.Objects;

/**
 * Created by msav on 5/17/2017.
 */
public class Project {

    private String projectName = "DEFAULT_NAME";
    private CommunicationProtocol communicationProtocol;
    private List<Stakeholder> stakeholders;
    private String domain;
    private UserInterfaceImpact uiImpact;
    private boolean webtestNeeded;
    private boolean integrationTestNeeded;
    private boolean javascriptTestNeeded;
    private boolean unitTestsNeeded;
    private List<Feature> features;
    private List<Technology> requestedTechnologies;
    private RefactoringLevel refactoringLevel;
    private Complexity complexity;
    private StoryPoints storyPoints;

    Project(String projectName, CommunicationProtocol communicationProtocol, List<Stakeholder> stakeholders, String domain, UserInterfaceImpact uiImpact, boolean webtestNeeded, boolean integrationTestNeeded, boolean javascriptTestNeeded, boolean unitTestsNeeded, List<Feature> features, List<Technology> requestedTechnologies, RefactoringLevel refactoringLevel, Complexity complexity, StoryPoints storyPoints) {
        this.projectName = projectName;
        this.communicationProtocol = communicationProtocol;
        this.stakeholders = stakeholders;
        this.domain = domain;
        this.uiImpact = uiImpact;
        this.webtestNeeded = webtestNeeded;
        this.integrationTestNeeded = integrationTestNeeded;
        this.javascriptTestNeeded = javascriptTestNeeded;
        this.unitTestsNeeded = unitTestsNeeded;
        this.features = features;
        this.requestedTechnologies = requestedTechnologies;
        this.refactoringLevel = refactoringLevel;
        this.storyPoints = storyPoints;
    }

    public CommunicationProtocol getCommunicationProtocol() {
        return communicationProtocol;
    }

    void setCommunicationProtocol(CommunicationProtocol communicationProtocol) {
        this.communicationProtocol = communicationProtocol;
    }

    public List<Stakeholder> getStakeholders() {
        return stakeholders;
    }

    void setStakeholders(List<Stakeholder> stakeholders) {
        this.stakeholders = stakeholders;
    }

    public String getDomain() {
        return domain;
    }

    void setDomain(String domain) {
        this.domain = domain;
    }

    public UserInterfaceImpact getUiImpact() {
        return uiImpact;
    }

    void setUiImpact(UserInterfaceImpact uiImpact) {
        this.uiImpact = uiImpact;
    }

    public boolean isWebtestNeeded() {
        return webtestNeeded;
    }

    void setWebtestNeeded(boolean webtestNeeded) {
        this.webtestNeeded = webtestNeeded;
    }

    public boolean isIntegrationTestNeeded() {
        return integrationTestNeeded;
    }

    void setIntegrationTestNeeded(boolean integrationTestNeeded) {
        this.integrationTestNeeded = integrationTestNeeded;
    }

    public boolean isJavascriptTestNeeded() {
        return javascriptTestNeeded;
    }

    void setJavascriptTestNeeded(boolean javascriptTestNeeded) {
        this.javascriptTestNeeded = javascriptTestNeeded;
    }

    public boolean isUnitTestsNeeded() {
        return unitTestsNeeded;
    }

    void setUnitTestsNeeded(boolean unitTestsNeeded) {
        this.unitTestsNeeded = unitTestsNeeded;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public RefactoringLevel getRefactoringLevel() {
        return refactoringLevel;
    }

    void setRefactoringLevel(RefactoringLevel refactoringLevel) {
        this.refactoringLevel = refactoringLevel;
    }

    public List<Technology> getRequestedTechnologies() {
        return requestedTechnologies;
    }

    void setRequestedTechnologies(List<Technology> requestedTechnologies) {
        this.requestedTechnologies = requestedTechnologies;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }

    public StoryPoints getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(StoryPoints storyPoints) {
        this.storyPoints = storyPoints;
    }

    public String getProjectName() {
        return projectName;
    }

    void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return isWebtestNeeded() == project.isWebtestNeeded() &&
                isIntegrationTestNeeded() == project.isIntegrationTestNeeded() &&
                isJavascriptTestNeeded() == project.isJavascriptTestNeeded() &&
                isUnitTestsNeeded() == project.isUnitTestsNeeded() &&
                Objects.equals(getProjectName(), project.getProjectName()) &&
                getCommunicationProtocol() == project.getCommunicationProtocol() &&
                Objects.equals(getStakeholders(), project.getStakeholders()) &&
                Objects.equals(getDomain(), project.getDomain()) &&
                getUiImpact() == project.getUiImpact() &&
                Objects.equals(getFeatures(), project.getFeatures()) &&
                Objects.equals(getRequestedTechnologies(), project.getRequestedTechnologies()) &&
                getRefactoringLevel() == project.getRefactoringLevel() &&
                Objects.equals(getComplexity(), project.getComplexity()) &&
                getStoryPoints() == project.getStoryPoints();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProjectName(), getCommunicationProtocol(), getStakeholders(), getDomain(), getUiImpact(), isWebtestNeeded(), isIntegrationTestNeeded(), isJavascriptTestNeeded(), isUnitTestsNeeded(), getFeatures(), getRequestedTechnologies(), getRefactoringLevel(), getComplexity(), getStoryPoints());
    }
}
