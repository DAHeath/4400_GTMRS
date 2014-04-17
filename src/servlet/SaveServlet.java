package servlet;

import database.RecordFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveServlet extends HttpServlet {
  private RecordFactory factory = new RecordFactory();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String recordType = getRecordType(request);
    String[] params = buildParams(request, recordType);
    factory.buildRecord(recordType, params).buildQuery().execute();
  }

  private String[] buildParams(HttpServletRequest request, String recordType) {
    String[] attributeNames = factory.getAttributeNames(recordType);
    String[] params = new String[attributeNames.length];
    for (int i = 0; i < attributeNames.length; i++)
      params[i] = request.getParameter(attributeNames[i]);
    return params;
  }

  private String getRecordType(HttpServletRequest request) {
    String path = request.getRequestURI();
    return path.substring(path.lastIndexOf('/')+1);
  }
}
