package servlet;

import patient.PatientAllergy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static patient.PatientAllergy.attributeNames;

public class SavePatientAllergyServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String[] params = new String[attributeNames.length];
    for (int i = 0; i < attributeNames.length; i++)
      params[i] = request.getParameter(attributeNames[i]);
    new PatientAllergy(params).buildQuery().execute();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
