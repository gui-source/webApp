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

@WebServlet("/item.html")
public class viewItemServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int index = Integer.parseInt(request.getParameter("index"));
        String fileName = request.getParameter("fileName");

        if(fileName.compareTo( "_lists.txt")==0){
            request.setAttribute("edit", false);
        }
        else{
            request.setAttribute("edit", true);
        }

        Model model = ModelFactory.getModel("data/" + fileName);
        String label = model.getLabel(index);
        String itemContent = model.getContent(index);

        request.setAttribute("index", index);
        request.setAttribute("itemLabel", label);
        request.setAttribute("itemContents", itemContent);
        request.setAttribute("fileName", fileName);

        // Invoke the JSP page.
        ServletContext context = request.getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/item.jsp");
        dispatch.forward(request, response);
    }
}
