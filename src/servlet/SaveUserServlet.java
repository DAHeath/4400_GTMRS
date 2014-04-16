package servlet;

import database.ActiveRecord;
import database.Query;
import database.RecordFactory;
import user.UserFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveUserServlet extends HttpServlet {
  private RecordFactory factory = new UserFactory();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    ActiveRecord user = factory.build(username, password);
    Query query = user.buildQuery();
    query.execute();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
