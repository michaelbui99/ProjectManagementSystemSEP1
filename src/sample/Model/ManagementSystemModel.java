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

  public void assignTeamMemberToRequirement(String requirementName, String name)
  {
    projectList.getProject(currentProject).getRequirementList().getRequirement().se;
  }

  public void assignTeamMemeberToTask(String taskName, TeamMember teamMember) {

  }

  public void assignTeamMemberRole(String name, String userRole) {

    employeeList.getEmployee(name).setRole(userRole);
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

  public String whoWhatWhen(String name) {



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
