package patient;

import database.ActiveRecord;
import servlet.SaveServletBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SavePatientAllergyServlet extends SaveServletBase {

  @Override
  protected String[] getAttributeNames() {
    return PatientAllergy.attributeNames;
  }

  @Override
  protected ActiveRecord getActiveRecord(String[] params) {
    return new PatientAllergy(params);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
