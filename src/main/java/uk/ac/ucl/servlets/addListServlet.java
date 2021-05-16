package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addList.html")
public class addListServlet extends  HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String filePath = "data/_lists.txt";
        String fileName = request.getParameter("newList")+".txt";
        Model model = ModelFactory.getModel(filePath);

        int newListIndex = model.addItem();

        model.setContent(newListIndex, fileName, "");

        Model.createFile(fileName);

        response.sendRedirect("displayAllLists.html");
    }

}
