package servlet;

import database.ActiveRecord;
import database.Query;
import database.RecordFactory;
import patient.PatientFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SavePatientServlet extends HttpServlet {
  private RecordFactory factory = new PatientFactory();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String name = request.getParameter("name");
    String dateOfBirth = request.getParameter("date_of_birth");
    String gender = request.getParameter("gender");
    String address = request.getParameter("address");
    String workPhone = request.getParameter("work_phone");
    String homePhone = request.getParameter("home_phone");
    String emergencyContactName = request.getParameter("emergency_contact_name");
    String emergencyContactPhone = request.getParameter("emergency_contact_phone");
    Float weight = Float.parseFloat(request.getParameter("weight"));
    Float height = Float.parseFloat(request.getParameter("height"));
    Integer annualIncome = Integer.parseInt(request.getParameter("annual_income"));
    String cardNumber = request.getParameter("card_number");

    ActiveRecord patient = factory.build(
            username,
            name,
            dateOfBirth,
            gender,
            address,
            workPhone,
            homePhone,
            emergencyContactName,
            emergencyContactPhone,
            weight,
            height,
            annualIncome,
            cardNumber
    );
    Query query = patient.buildQuery();
    query.execute();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
