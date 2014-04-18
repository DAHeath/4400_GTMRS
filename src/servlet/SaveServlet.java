package servlet;

import database.RecordFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveServlet extends HttpServlet {
  private final RecordFactory factory = new RecordFactory();
  private HttpServletRequest request;
  private HttpServletResponse response;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.request = request;
    this.response = response;
    String recordType = getRecordType();
    String[] params = buildParams(recordType);
    factory.buildRecord(recordType, params).buildQuery().execute();
    redirect(recordType);
  }

  private String[] buildParams(String recordType) {
    String[] attributeNames = factory.getAttributeNames(recordType);
    String[] params = new String[attributeNames.length];
    for (int i = 0; i < attributeNames.length; i++)
      params[i] = request.getParameter(attributeNames[i]);
    return params;
  }

  private String getRecordType() {
    String path = request.getRequestURI();
    path = path.substring(path.lastIndexOf('/')+1);
    return path.substring(path.indexOf('_')+1);
  }

  private void redirect(String recordType) throws IOException {
    if (recordType.equals("user")) {
      if (request.getParameter("type").equals("doctor"))
        response.sendRedirect("register_doctor.jsp");
      else if (request.getParameter("type").equals("patient"))
        response.sendRedirect("register_patient.jsp");
    }
  }
}
