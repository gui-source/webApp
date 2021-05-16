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

@WebServlet("/displayAllLists.html")
public class displayAllListsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Model model = ModelFactory.getModel("data/_lists.txt");
        List<String> stringItems = model.getStringItems();

        request.setAttribute("stringItems", stringItems);

        ServletContext context = request.getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/displayAllLists.jsp");
        dispatch.forward(request, response);
    }

}
