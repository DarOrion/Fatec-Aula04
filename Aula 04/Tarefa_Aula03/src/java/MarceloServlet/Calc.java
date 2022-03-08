/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package MarceloServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marce
 */
@WebServlet(name = "Calc", urlPatterns = {"/operacao.html"})
public class Calc extends HttpServlet {

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
        int conta1 = 1;
        int conta2 = 1;
        int resolucao;
        String op = null;
        String error = null;
        try{
            String c1 = request.getParameter("conta1");
            String c2 = request.getParameter("conta2");
            op = request.getParameter("op");
            conta1 = Integer.parseInt(c1);
            conta2 = Integer.parseInt(c2);

            
        }catch(Exception ex){
            error = ex.getMessage();
        }
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MathServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Por favor, escolha qual operação deseja realizar</h2>");
            out.println("<form>");
            out.println("<input type='number' name='conta1' value='1'/>");
            out.println("<select name='op'>");
            out.println("<option>+</option>");
            out.println("<option>-</option>");
            out.println("<option>*</option>");
            out.println("<option>/</option>");
            out.println("</select>");
            out.println("<input type='number' name='conta2' value='1'/>");
            out.println("<input type='submit' value='='/>");
            out.println("</form>");
            out.println("<hr>");
            if(error!=null){
                out.println("<div style='color:red'>Erro na tentativa de leitura dos parâmetros: "+error+"</div>");
            }else{
                out.println("<div>");
                switch(op){
                    case "+": 
                        resolucao = conta1+conta2;
                        out.println(conta1+" + "+conta2+" = "+resolucao);
                        break;
                    case "-":
                        resolucao = conta1-conta2;
                        out.println(conta1+" - "+conta2+" = "+resolucao);
                        break;
                    case "*":
                        resolucao = conta1 * conta2;
                        out.println(conta1+" * "+conta2+" = "+resolucao);
                        break;
                    case "/": 
                        resolucao = conta1 / conta2;
                        out.println(conta1+" / "+conta2+" = "+resolucao);
                        break;
                    default:
                        out.println("Invalido");
                }
                out.println("</div>");
            }
            out.println("</body>");
            out.println("</html>");
        }
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
