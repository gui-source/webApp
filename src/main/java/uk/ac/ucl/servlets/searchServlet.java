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

@WebServlet("/runsearch.html")
public class searchServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Model model = ModelFactory.getModel("data/_lists.txt");
        String keyword = request.getParameter("searchstring");
        List<String> searchResult = model.searchFor(keyword);

        request.setAttribute("keyword", keyword);
        request.setAttribute("result", searchResult);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/searchResult.jsp");
        dispatch.forward(request, response);
    }
}
