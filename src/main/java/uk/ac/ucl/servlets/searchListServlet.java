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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/searchList.html")
public class searchListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkAll = request.getParameter("checkAll");
        String keyword = request.getParameter("keyword");
        int fileNum = Integer.parseInt(request.getParameter("fileNum"));
        // ls containing fileNames of files to search for this keyword
        List<String> ls = new ArrayList<>();

        if (checkAll != null){
            Model model = ModelFactory.getModel("data/_lists.txt");

            ls = new ArrayList<>(model.getStringItems());
        }
        else{
            for (int i = 0; i < fileNum; i++) {
                String s = request.getParameter("file"+i);
                if (s != null){
                    ls.add(s);
                }
            }
        }

        List<String> res = new ArrayList<>();
        List<String> resLinks = new ArrayList<>();

        for (String fileName :
                ls) {
            Model model = ModelFactory.getModel("data/" + fileName);
            model.addResults(keyword, res, resLinks);
        }

        request.setAttribute("keyword", keyword);
        request.setAttribute("res", res);
        request.setAttribute("resLinks", resLinks);


        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/searchList.jsp");
        dispatch.forward(request, response);

    }
}