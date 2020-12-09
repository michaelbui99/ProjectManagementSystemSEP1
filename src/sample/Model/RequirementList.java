package sample.Model;
import java.util.ArrayList;

public class RequirementList
{
  private ArrayList<Requirement> requirements;
  //Fields


  RequirementList ()
  {
    this.requirements = new ArrayList<Requirement>();
  }



  public void addRequirement(Requirement requirement)
  {
    requirements.add(requirement);
  }



  public void removeRequirement(int  requirementID)
  {
    for (int i = 0; i < requirements.size(); i++)
    {
      if (requirements.get(i).getRequirementID()==(requirementID))
        requirements.remove(i);
    }
  }


  //Getter


  public Requirement getRequirement(int requirementID)
  {
    for (int i = 0; i < requirements.size(); i++)
    {
      if (requirements.get(i).getRequirementID() == requirementID)
        return requirements.get(i);
    }
    return null;
  }

  public ArrayList<Requirement> getAllRequirements()
  {
    return requirements;
  }

  @Override public String toString()
  {
    return "RequirementList: " + requirements;
  }
}
