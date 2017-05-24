package model.builder;

import model.*;

import java.util.List;

public class ProjectBuilder {
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

    public ProjectBuilder setCommunicationProtocol(CommunicationProtocol communicationProtocol) {
        this.communicationProtocol = communicationProtocol;
        return this;
    }

    public ProjectBuilder setStakeholders(List<Stakeholder> stakeholders) {
        this.stakeholders = stakeholders;
        return this;
    }

    public ProjectBuilder setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public ProjectBuilder setUiImpact(UserInterfaceImpact uiImpact) {
        this.uiImpact = uiImpact;
        return this;
    }

    public ProjectBuilder setWebtestNeeded(boolean webtestNeeded) {
        this.webtestNeeded = webtestNeeded;
        return this;
    }

    public ProjectBuilder setIntegrationTestNeeded(boolean integrationTestNeeded) {
        this.integrationTestNeeded = integrationTestNeeded;
        return this;
    }

    public ProjectBuilder setJavascriptTestNeeded(boolean javascriptTestNeeded) {
        this.javascriptTestNeeded = javascriptTestNeeded;
        return this;
    }

    public ProjectBuilder setUnitTestsNeeded(boolean unitTestsNeeded) {
        this.unitTestsNeeded = unitTestsNeeded;
        return this;
    }

    public ProjectBuilder setFeatures(List<Feature> features) {
        this.features = features;
        return this;
    }

    public ProjectBuilder setRequestedTechnologies(List<Technology> requestedTechnologies) {
        this.requestedTechnologies = requestedTechnologies;
        return this;
    }

    public ProjectBuilder setRefactoringLevel(RefactoringLevel refactoringLevel) {
        this.refactoringLevel = refactoringLevel;
        return this;
    }

    public ProjectBuilder setComplexity(Complexity complexity) {
        this.complexity = complexity;
        return this;
    }

    public ProjectBuilder setStoryPoints(StoryPoints storyPoints) {
        this.storyPoints = storyPoints;
        return this;
    }

    public Project createProject() {
        return new Project(communicationProtocol, stakeholders, domain, uiImpact, webtestNeeded, integrationTestNeeded, javascriptTestNeeded, unitTestsNeeded, features, requestedTechnologies, refactoringLevel, complexity, storyPoints);
    }
}