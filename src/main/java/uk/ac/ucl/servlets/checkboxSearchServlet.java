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

@WebServlet("/checkboxSearch.html")
public class checkboxSearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel("data/_lists.txt");

        List<String> files = model.getStringItems();

        request.setAttribute("files", files);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/checkboxSearch.jsp");
        dispatch.forward(request, response);

    }
}