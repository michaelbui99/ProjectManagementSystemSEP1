package sample.util;

import parser.ParserException;
import parser.XmlJsonParser;
import sample.Model.ProjectList;

public class fileHandler
{
  public static void save(ProjectList list)
  {
    saveToXml(list);
  }

  public static void saveToXml(ProjectList list)
  {
    XmlJsonParser parser = new XmlJsonParser();
    try
    {
      parser.toXml(list, "ProjectList.bin");
    }
    catch (ParserException e)
    {
      e.printStackTrace();
    }
  }
}
