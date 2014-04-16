package user;

import database.ActiveRecord;
import servlet.SaveServletBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveUserServlet extends SaveServletBase {

  @Override
  protected String[] getAttributeNames() {
    return User.attributeNames;
  }

  @Override
  protected ActiveRecord getActiveRecord(String[] params) {
    return new User(params);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    super.doPost(request, response);
    String type = request.getParameter("type");
    if (type.equals("patient"))
      response.sendRedirect("./register_patient.jsp");
    else if (type.equals("doctor"))
      response.sendRedirect("./register_doctor.jsp");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
