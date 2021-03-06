/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksist.ormapping.sample.servlet;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ksist.ormapping.sample.BookSessionBean;
import ksist.ormapping.sample.entity.Book;

/**
 *
 * @author kasai
 */
@WebServlet(urlPatterns = {"/bookOrderInput"})
public class BookOrderInputServlet extends HttpServlet {

    @EJB
    BookSessionBean bean;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<Book> list = bean.findAll();
        
        String bookList[] = request.getParameterValues("bookList");
        String customerName = request.getParameter("customerName");
        request.setAttribute("customerName", customerName);
        
        if ("delete".equals(request.getParameter("doAction"))) {
            String tempBookList[] = new String[bookList.length - 2];
            int tempIdx = 0;
            for (int i = 0; i < bookList.length - 1; i++) {
                if (i != Integer.parseInt(request.getParameter("index"))) {
                    tempBookList[tempIdx] = bookList[i];
                    tempIdx++;
                }
            }
            if (tempBookList.length == 0) {
                request.setAttribute("bookList", null);
            } else {
                request.setAttribute("bookList", tempBookList);
            }
        } else if ("add".equals(request.getParameter("doAction"))) {
            request.setAttribute("bookList", bookList);
        }
        request.setAttribute("books", list);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bookOrder.jsp");
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
