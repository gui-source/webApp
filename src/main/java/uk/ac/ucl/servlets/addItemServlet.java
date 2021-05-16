package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addItem.html")
public class addItemServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String fileName = request.getParameter("fileName");
        Model model = ModelFactory.getModel("data/"+fileName);

        int newItemIndex = model.addItem();

        response.sendRedirect("editItem.html?fileName="+fileName+"&index="+newItemIndex);
    }
}
