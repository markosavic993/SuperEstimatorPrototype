package main;

import com.google.common.collect.Lists;
import estimator.EstimatorBuilder;
import estimator.Estimator;
import model.*;
import model.ProjectBuilder;
import model.TeamBuilder;
import rules.ProjectRulesType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by msav on 5/17/2017.
 */
public class Runner {
    private static Project projectA;
    private static Project projectB;
    private static Team teamA;


    public static void main(String[] args) {
        createTestStructure();

        Estimator superEstimator = new EstimatorBuilder()
                .createEstimator()
                .withExplanation()
                .forProjectType(ProjectRulesType.DEFAULT)
                .build();

        StoryPoints predictedStoryPointsA =
                superEstimator.estimateProjectForTeam(projectA, teamA);
        System.out.println("Team should estimate project A with " + predictedStoryPointsA.getNumOfStoryPoints() + " sp.");

        System.out.println("===============================================================");

        StoryPoints predictedStoryPointsB =
                superEstimator.estimateProjectForTeam(projectB, teamA);
        System.out.println("Team should estimate project B with " + predictedStoryPointsB.getNumOfStoryPoints() + " sp.");

        System.out.println("===============================================================");

        StoryPoints predictedStoryPointsC =
                superEstimator.estimateProjectForTeam(projectB, teamA);
        System.out.println("Team should estimate project B with " + predictedStoryPointsC.getNumOfStoryPoints() + " sp.");
    }


    private static void createTestStructure() {
        createProjectA();
        createProjectB();
        createTeamA();
    }

    private static void createTeamA() {
        teamA = new TeamBuilder()
                .setDistributed(true)
                .setNumberOfMembers(10)
                .setStructure(createTeamStructureA())
                .setFamiliarDomains(createListOfFamiliarDomainsA())
                .setKnownFeatures(createListOfFeaturesTeamA())
                .setProjects(Lists.newArrayList(projectA, projectB))
                .setScrumTools(createScrumToolsA())
                .setTechnologies(createTechnologiesTeamA())
                .setStakeholderExperienceMap(createStakeholdersExperienceMapA())
                .createTeam();
    }

    private static Map<Stakeholder, StakeholderExperience> createStakeholdersExperienceMapA() {
        Map<Stakeholder, StakeholderExperience> experienceMap = new HashMap();
        experienceMap.put(new Stakeholder("Manuel", StakeholderType.BUSSINES_ANALYST), StakeholderExperience.BAD);
        experienceMap.put(new Stakeholder("Nicole", StakeholderType.BUSSINES), StakeholderExperience.GOOD);
        experienceMap.put(new Stakeholder("Mediator", StakeholderType.EXTERNAL_SYSTEM), StakeholderExperience.BAD);
        experienceMap.put(new Stakeholder("Regina", StakeholderType.BUSSINES), StakeholderExperience.NORMAL);
        experienceMap.put(new Stakeholder("Jeneate", StakeholderType.QA), StakeholderExperience.GOOD);

        return experienceMap;
    }

    private static List<Technology> createTechnologiesTeamA() {
        return Lists.newArrayList(
                new Technology("Java", Popularity.HIGH),
                new Technology("Javascript", Popularity.HIGH),
                new Technology("EcmaScript6", Popularity.MEDIUM),
                new Technology("EcmaScript5", Popularity.MEDIUM),
                new Technology("Karma", Popularity.MEDIUM),
                new Technology("Spring", Popularity.HIGH)
        );
    }

    private static ArrayList<ScrumTools> createScrumToolsA() {
        return Lists.newArrayList(
                new ScrumTools("Trello", "desc"),
                new ScrumTools("Jira", "desc"),
                new ScrumTools("SuperEstimator", "desc")
        );
    }

    private static List<Feature> createListOfFeaturesTeamA() {
        return Lists.newArrayList(
                new Feature("Interface creation", "desc"),
                new Feature("Feature toggles", "desc"),
                new Feature("CDC testing", "desc"),
                new Feature("Creation of mock", "desc")
        );
    }

    private static List<String> createListOfFamiliarDomainsA() {
        return Lists.newArrayList("Combox", "SME", "TWIX", "ESIM");
    }

    private static TeamStructure createTeamStructureA() {
        return new TeamStructure(8, 2);
    }

    private static void createProjectA() {
        ProjectBuilder projectBuilder = new ProjectBuilder();
        projectA = projectBuilder
                .setProjectName("ProjectA")
                .setCommunicationProtocol(CommunicationProtocol.REST)
                .setFeatures(createListOfFeaturesA())
                .setStakeholders(createListOfStakeholdersA())
                .setDomain("Combox")
                .setIntegrationTestNeeded(true)
                .setUnitTestsNeeded(true)
                .setWebtestNeeded(false)
                .setJavascriptTestNeeded(false)
                .setRequestedTechnologies(createListOfTechnologiesA())
                .setRefactoringLevel(RefactoringLevel.LOW)
                .setUiImpact(UserInterfaceImpact.SMALL)
                .createProject();
    }

    private static void createProjectB() {
        ProjectBuilder projectBuilder = new ProjectBuilder();
        projectB = projectBuilder
                .setProjectName("ProjectB")
                .setCommunicationProtocol(CommunicationProtocol.UNDEFINED)
                .setFeatures(createListOfFeaturesB())
                .setStakeholders(createListOfStakeholdersB())
                .setDomain("MYAPP")
                .setIntegrationTestNeeded(false)
                .setUnitTestsNeeded(false)
                .setWebtestNeeded(false)
                .setJavascriptTestNeeded(false)
                .setRequestedTechnologies(createListOfTechnologiesB())
                .setRefactoringLevel(RefactoringLevel.HIGH)
                .setUiImpact(UserInterfaceImpact.LARGE)
                .createProject();
    }

    private static List<Technology> createListOfTechnologiesB() {
        Technology technology = new Technology("Java", Popularity.HIGH);
        Technology technology1 = new Technology("XSL", Popularity.LOW);
        Technology technology2 = new Technology("XML", Popularity.MEDIUM);
        Technology technology3 = new Technology("Kotlin", Popularity.LOW);

        return Lists.newArrayList(technology, technology1, technology2, technology3);
    }

    private static List<Stakeholder> createListOfStakeholdersB() {
        Stakeholder stakeholder = new Stakeholder("Mediator", StakeholderType.EXTERNAL_SYSTEM);
        Stakeholder stakeholder1 = new Stakeholder("Petkov", StakeholderType.BUSSINES_ANALYST);
        Stakeholder stakeholder2 = new Stakeholder("Nicole", StakeholderType.BUSSINES);
        Stakeholder stakeholder3 = new Stakeholder("Alex Kohler", StakeholderType.DEVELOPER);

        return Lists.newArrayList(stakeholder, stakeholder1, stakeholder2, stakeholder3);
    }

    private static List<Feature> createListOfFeaturesB() {
        Feature feature = new Feature("SomeUnknownFeature", "Description for feature toggles");
        return Lists.newArrayList(feature);
    }

    private static List<Technology> createListOfTechnologiesA() {
        Technology technology = new Technology("Java", Popularity.HIGH);
        Technology technology1 = new Technology("Javascript", Popularity.HIGH);
        Technology technology2 = new Technology("EcmaScript6", Popularity.MEDIUM);

        return Lists.newArrayList(technology, technology1, technology2);
    }

    private static List<Stakeholder> createListOfStakeholdersA() {
        Stakeholder stakeholder = new Stakeholder("Mediator", StakeholderType.EXTERNAL_SYSTEM);
        Stakeholder stakeholder1 = new Stakeholder("Manuel", StakeholderType.BUSSINES_ANALYST);
        Stakeholder stakeholder2 = new Stakeholder("Jeneate", StakeholderType.QA);

        return Lists.newArrayList(stakeholder, stakeholder1, stakeholder2);
    }

    private static List<Feature> createListOfFeaturesA() {
        Feature feature = new Feature("Interface creation", "Some description");
        Feature feature1 = new Feature("Browser voice recording", "Some other description");
        List<Feature> features = new ArrayList<Feature>();
        features.add(feature);
        features.add(feature1);
        return features;
    }
}
