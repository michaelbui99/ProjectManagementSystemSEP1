package sample.Model;

public class ManagementSystemModel
{

  private String userRole;

  private String currentProject;

  private ProjectList projectList;

  private EmployeeList employeeList;

  private ProjectFile projectFile;

  public ManagementSystemModel() {
    projectList = new ProjectList();
    employeeList = new EmployeeList();
    currentProject = ""; //Ved start er der ingen projekter valgt endnu.
    projectFile = null;
  }

  public void setUser(String userRole) {
    this.userRole = userRole;
  }

  public void createProject(String name, int projectID, MyDate deadLine) {
    projectList.getAllProjects().add(name, projectID, deadLine);
  }

  public void createRequirement(int requirementID, String responsibleTeamMember, String status) {
    for (Project project: projectList.getAllProjects())
    {
      if (project.getProjectName().equals(currentProject))
      {
        project.getRequirementList().addRequirement(new Requirement(requirementID,responsibleTeamMember,status));
      }
    }
  }

  public void createTask(int taskID, String status) {

  }

  public void removeProject(String name) {

  }

  public void removeRequirement(String name) {

  }

  public void removeTask(String name) {

  }

  public void assignTeamMemberToProject(String projectName, TeamMember teamMember) {

  }

  /*TODO: Michael implements the 8 first methods.*/

  public void assignTeamMemberToRequirement(int requirementID, TeamMember teamMember)
  {
    projectList.getProject(currentProject).getRequirementList().getRequirement(requirementID).setResponsibleTeamMember(teamMember);
  }

  public void assignTeamMemeberToTask(int taskID, TeamMember teamMember, int reqID) {
    projectList.getProject(currentProject).getRequirementList().getRequirement(reqID).getTaskList().getTask(taskID).getAllTaskEmployees().add(teamMember.copy());

  }

  public void assignTeamMemberRole(String name, String userRole) {

    projectList.getProject(currentProject).getEmployeeList().getEmployee(name).setRole(userRole);
  }

  public void removeTeamMemberFromProject(String projectName, TeamMember teamMember) {

  }

  public void removeTeamMemberFromRequirement(String requirementName, TeamMember teamMember) {

  }

  public void removeTeamMemberFromTask(String taskName, TeamMember teamMember) {

  }

  public ProjectList getProjectList() {
    return projectList;
  }

  public EmployeeList getEmployeeList() {
    return employeeList;
  }

  /*TODO: Kaser implements the next 8 methods*/

  public Project getProjectInfoByEmployeeName(String name) {
    return null;
  }

  public Project getProjectInfo(String projectName) {
    return null;
  }

  public float getProjectProgress(String projectName) {
    return 0;
  }

  public void loadProject() {

  }

  public void saveProject() {

  }

  public void addEmployeeToSystem(String name, int ID) {

  }

  public void removeEmployeeFromSystem(String name) {

  }

  public void setProjectStatus(String status, String projectName) {

  }

  /*TODO: Kutaiba implements the next 8*/

  public void setRequirementStatus(String status, int requirementID) {

   projectList.getProject(currentProject).getRequirementList().
       getRequirement(requirementID).setStatus(status);

  }

  public void setTaskStatus(String status, int taskID, int requirementID) {

    projectList.getProject(currentProject).getRequirementList().
        getRequirement(requirementID).getTaskList().getTask(taskID).
        setStatus(status);

  }

  public void setRequirementPriority(String priority, int requirementID) {

    projectList.getProject(currentProject).getRequirementList().
        getRequirement(requirementID).setPriority(priority);

  }

  public String whoWhatWhen(int requirementID) {

    return projectList.getProject(currentProject).getRequirementList().
        getRequirement(requirementID).getUserStory();
  }

  public void registerTaskTime(int time, int requirementID, int taskID) {

    projectList.getProject(currentProject).getRequirementList().
        getRequirement(requirementID).getTaskList().getTask(taskID).
        registerTimeSpent(time);

  }

  public void registerReqTime(int requirementID, int time) {

    projectList.getProject(currentProject).getRequirementList().
        getRequirement(requirementID).setTimeSpendInHours(time);

  }

  public int getTaskTime(String taskName, int requirementID, int taskID) {

    return projectList.getProject(currentProject).getRequirementList().
        getRequirement(requirementID).getTaskList().getTask(taskID).
        getTimeSpendInHours();
  }

  public int getReqTime(int requirementID, int time) {

    return projectList.getProject(currentProject).getRequirementList().
        getRequirement(requirementID).getTimeSpendInHours();
  }

  /*TODO: Lilian implements the next 8.*/

  public RequirementList getRequirementList(String projectName) {
    return null;
  }

  public TeamMember getResponsibleTeamMemberReq(String reqName) {
    return null;
  }

  public TeamMember getResponsibleTeamMemberTask(String taskName) {
    return null;
  }

  public MyDate getReqDeadline(String requirementName) {
    return null;
  }

  public MyDate getTaskDeadline(String taskName) {
    return null;
  }

  public MyDate getProjectDeadline(String projectName) {
    return null;
  }

  /*TODO: Christian implements the last 8 methods*/

}
