package Controller;

import Controller.Actions.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 *
 * @author S2-PC00
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //ACTION=PRODUCT.FIND_ALL

        //request se forma con todos eso
        String action = request.getParameter("ACTION");
        //String example = request.getParameter("DI");

        String[] arrayAction = new String[2];
        if (action != "")
        {
            arrayAction = action.split("\\."); //[0] PRODUCT <-> [1] FIND_ALL
        }
        switch (arrayAction[0].toUpperCase())
        {
            case "ALLERGEN":
            {
                out.print(new AllergenAction().execute(request,response, arrayAction[1].toUpperCase()));
                break;
            }
            case "CANDIDATE":
            {
                out.print(new CandidateAction().execute(request,response, arrayAction[1].toUpperCase()));
                break;
            }
            case "CATEGORY":
            {
                out.print(new CategoryAction().execute(request,response, arrayAction[1].toUpperCase()));
                break;
            }
            case "CLIENT":
            {
                out.print(new ClientAction().execute(request,response, arrayAction[1].toUpperCase()));
                break;
            }
            case "EMPLOYEE":
            {
                out.print(new EmployeeAction().execute(request,response, arrayAction[1].toUpperCase()));
                break;
            }
            case "ESTABLISHMENT":
            {
                out.print(new EstablishmentAction().execute(request,response, arrayAction[1].toUpperCase()));
                break;
            }
            case "JOB":
            {
                out.print(new JobAction().execute(request,response, arrayAction[1].toUpperCase()));
                break;
            }
            case "JOBOFFER":
            {
                out.print(new JobOfferAction().execute(request,response, arrayAction[1].toUpperCase()));
                break;
            }
            case "ORDER":
            {
                out.print(new OrderAction().execute(request,response, arrayAction[1].toUpperCase()));
                break;
            }
            case "ORDERDETAIL":
            {
                out.print(new OrderDetailAction().execute(request,response, arrayAction[1].toUpperCase()));
                break;
            }
            case "PAYMENTMETHOD":
            {
                out.print(new PaymentMethodAction().execute(request,response, arrayAction[1].toUpperCase()));
                break;
            }
            case "PRODUCT":
            {
                out.print(new ProductAction().execute(request,response, arrayAction[1].toUpperCase()));
                break;
            }
            case "USER":
            {
                out.print(new UserAction().execute(request,response, arrayAction[1].toUpperCase()));
                break;
            }

            default:
            {
                System.out.println(action);
                throw new ServletException ("Acción " + action +" no valida");
            }
        }
        System.out.println(action);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
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
    protected void doPost(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }


    private static String getBody(HttpServletRequest request)  {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            // throw ex;
            return "";
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {

                }
            }
        }

        body = stringBuilder.toString();
        return body;
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


