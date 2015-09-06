/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksist.ormapping.sample.servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ksist.ormapping.sample.BookSessionBean;
import ksist.ormapping.sample.entity.Book;
import ksist.ormapping.sample.entity.ForeignBook;
import ksist.ormapping.sample.entity.JapaneseBook;

/**
 *
 * @author kasai
 */
@WebServlet(urlPatterns = {"/addBook"})
public class AddBookServlet extends HttpServlet {

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

        Book book = null;
        String type = request.getParameter("bookType");
        if (null != type) switch (type) {
            case "japanese":
                book = new JapaneseBook();
                break;
            case "foreign":
                book = new ForeignBook();
                break;
            default:
                throw new ServletException("invalid argument");
        }
        book.setBookName(request.getParameter("bookName"));
        book.setStockCount(Integer.parseInt(request.getParameter("stockCount")));
        bean.add(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/bookManage");
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
