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
    projectList.addProject(new Project(name, projectID, deadLine));
  }

  public void createRequirement(String name, int requirementID, TeamMember responsibleTeamMember,
      String status, String priority, MyDate deadline) {
    for (Project project: projectList.getAllProjects())
    {
      if (project.getProjectName().equals(currentProject))
      {
        project.getRequirementList().addRequirement(new Requirement(name, requirementID, responsibleTeamMember, status, priority, deadline);
      }
    }
  }

  public void createTask(int requirementID, String name, int taskID, String status, TeamMember responsibleTeamMember, String priority, MyDate deadline) {
    for (Project project: projectList.getAllProjects())
    {
      if (project.getProjectName().equals(currentProject))
      {
        project.getRequirementList().getRequirement(requirementID).getTaskList().addTask(new Task(name, taskID, status,responsibleTeamMember,priority,deadline));
      }
    }
  }

  public void removeProject(String name) {
    projectList.removeProject(name);
  }

  public void removeRequirement(int requirementID) {
    for (Project project: projectList.getAllProjects())
    {
      if (project.getProjectName().equals(currentProject))
      {
        project.getRequirementList().removeRequirement(requirementID);
      }
    }
  }

  public void removeTask(int requirementID, int taskID) {
    for (Project project: projectList.getAllProjects())
    {
      if (project.getProjectName().equals(currentProject))
      {
        project.getRequirementList().getRequirement(requirementID).getTaskList().removeTask(taskID);
      }
    }

  }

  public void assignTeamMemberToProject(String projectName, String teamMemberName) {
    TeamMember teamMemberToAdd = null;
    for (TeamMember teamMember: employeeList)
    {
      if (teamMember.getName().equals(teamMemberName))
      {
        teamMemberToAdd = teamMember.copy();
      }
    }

    for (Project project: projectList.getAllProjects())
    {
      if (project.getProjectName().equals(projectName))
      {
        project.getEmployeeList().addEmployee(teamMemberToAdd);
      }
    }
  }

  /*TODO: Michael implements the 8 first methods.*/

  public void assignTeamMemberToRequirement(String requirementName, TeamMember teamMember)
  {

  }

  public void assignTeamMemeberToTask(String taskName, TeamMember teamMember) {

  }

  public void assignTeamMemberRole(String name) {

    employeeList.getEmployee().
  }

  public void removeTeamMemberFromProject(String projectName, TeamMember teamMember) {

  }

  public void removeTeamMemberFromRequirement(String requirementName, TeamMember teamMember) {

  }

  public void removeTeamMemberFromTask(String taskName, TeamMember teamMember) {

  }

  public ProjectList getProjectList() {
    return null;
  }

  public EmployeeList getEmployeeList() {
    return null;
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

  public void setRequirementStatus(String status, String requirementName) {

  }

  public void setTaskStatus(String status, String taskName) {

  }

  public void setRequirementPriority(String priority, String requirementName) {

  }

  public String whoWhatWhen(String name) {
    return null;
  }

  public void registerTaskTime(String taskName, int time) {

  }

  public void registerReqTime(String RequirementName, int time) {

  }

  public int getTaskTime(String taskName) {
    return 0;
  }

  public int getReqTime(String reqName) {
    return 0;
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
