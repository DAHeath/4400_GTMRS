package servlet;

import patient.Patient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static patient.Patient.attributeNames;

public class SavePatientServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String[] params = new String[attributeNames.length];
    for (int i = 0; i < attributeNames.length; i++)
      params[i] = request.getParameter(attributeNames[i]);
    new Patient(params).buildQuery().execute();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
