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
import java.io.File;
import java.io.IOException;

@WebServlet("/deleteList.html")
public class deleteListServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String fileName = request.getParameter("fileName");
        File fdel = new File ("data/"+fileName);

        Model model = ModelFactory.getModel("data/_lists.txt");

        boolean deleted = false;
        try{
            if (fdel.delete()){
                deleted = true;
                model.removeItem(fileName);
            }
            else{
                deleted = false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        request.setAttribute("deleted", deleted);

        ServletContext context = request.getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/deleteList.jsp");
        dispatch.forward(request, response);
    }
}
