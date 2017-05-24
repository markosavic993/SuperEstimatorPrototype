package model;

import java.util.List;

/**
 * Created by msav on 5/17/2017.
 */
public class Project {

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

    public Project() {
    }

    public Project(CommunicationProtocol communicationProtocol, List<Stakeholder> stakeholders, String domain, UserInterfaceImpact uiImpact, boolean webtestNeeded, boolean integrationTestNeeded, boolean javascriptTestNeeded, boolean unitTestsNeeded, List<Feature> features, List<Technology> requestedTechnologies, RefactoringLevel refactoringLevel, Complexity complexity, StoryPoints storyPoints) {
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

    public void setCommunicationProtocol(CommunicationProtocol communicationProtocol) {
        this.communicationProtocol = communicationProtocol;
    }

    public List<Stakeholder> getStakeholders() {
        return stakeholders;
    }

    public void setStakeholders(List<Stakeholder> stakeholders) {
        this.stakeholders = stakeholders;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public UserInterfaceImpact getUiImpact() {
        return uiImpact;
    }

    public void setUiImpact(UserInterfaceImpact uiImpact) {
        this.uiImpact = uiImpact;
    }

    public boolean isWebtestNeeded() {
        return webtestNeeded;
    }

    public void setWebtestNeeded(boolean webtestNeeded) {
        this.webtestNeeded = webtestNeeded;
    }

    public boolean isIntegrationTestNeeded() {
        return integrationTestNeeded;
    }

    public void setIntegrationTestNeeded(boolean integrationTestNeeded) {
        this.integrationTestNeeded = integrationTestNeeded;
    }

    public boolean isJavascriptTestNeeded() {
        return javascriptTestNeeded;
    }

    public void setJavascriptTestNeeded(boolean javascriptTestNeeded) {
        this.javascriptTestNeeded = javascriptTestNeeded;
    }

    public boolean isUnitTestsNeeded() {
        return unitTestsNeeded;
    }

    public void setUnitTestsNeeded(boolean unitTestsNeeded) {
        this.unitTestsNeeded = unitTestsNeeded;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public RefactoringLevel getRefactoringLevel() {
        return refactoringLevel;
    }

    public void setRefactoringLevel(RefactoringLevel refactoringLevel) {
        this.refactoringLevel = refactoringLevel;
    }

    public List<Technology> getRequestedTechnologies() {
        return requestedTechnologies;
    }

    public void setRequestedTechnologies(List<Technology> requestedTechnologies) {
        this.requestedTechnologies = requestedTechnologies;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }

    @Override
    public String toString() {
        return this.complexity.getTechnicalComplexity() + " " +
                this.complexity.getCommunicationComplexity() + " " +
                this.complexity.getCoordinationComplexity()
                + "==========================" + this.storyPoints;
    }

    public StoryPoints getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(StoryPoints storyPoints) {
        this.storyPoints = storyPoints;
    }
}
