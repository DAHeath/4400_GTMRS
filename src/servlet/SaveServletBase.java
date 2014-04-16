package servlet;

import database.ActiveRecord;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class SaveServletBase extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String[] attributeNames = getAttributeNames();
    String[] params = new String[attributeNames.length];
    for (int i = 0; i < attributeNames.length; i++)
      params[i] = request.getParameter(attributeNames[i]);
    getActiveRecord(params).buildQuery().execute();
  }

  protected abstract String[] getAttributeNames();
  protected abstract ActiveRecord getActiveRecord(String[] params);
}
