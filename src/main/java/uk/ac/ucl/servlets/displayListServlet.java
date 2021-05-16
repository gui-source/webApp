package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/displayList.html")
public class displayListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Get the data from the model
        String fileName = request.getParameter("fileName");
        Model model = ModelFactory.getModel("data/" + fileName);
        List<String> stringItems = model.getStringItems();

        request.setAttribute("stringItems", stringItems);

        ServletContext context = request.getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/displayList.jsp");
        dispatch.forward(request, response);
    }

}
