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

@WebServlet("/editItem.html")
public class editItemServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        int index = Integer.parseInt(request.getParameter("index"));

        Model model = ModelFactory.getModel("data/" + fileName);
        String label = model.getLabel(index);

        request.setAttribute("index", index);
        request.setAttribute("itemLabel", label);
        request.setAttribute("itemContent", model.getContent(index));

        ServletContext context = request.getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/editItem.jsp");
        dispatch.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("index"));
        String fileName = request.getParameter("fileName");
        String newLabel = request.getParameter("newLabel");
        String newContent = request.getParameter("newContent");

        Model model = ModelFactory.getModel("data/" + fileName);
        model.setContent(index, newLabel, newContent);

        request.setAttribute("index", index);
        request.setAttribute("itemLabel", newLabel);
        request.setAttribute("itemContent", newContent);

        response.sendRedirect("displayList.html?fileName="+fileName);
    }

}
