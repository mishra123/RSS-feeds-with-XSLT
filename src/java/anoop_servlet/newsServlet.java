/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anoop_servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
/**
 *
 * @author 2012
 */
public class newsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
            String abc=request.getParameter("opt");
            String abc1=request.getParameter("opt1");
            request.setAttribute("abc", abc);
            request.setAttribute("abc1",abc1);
            String url;
            if("Business".equals(abc))
            {
                url="http://rss.nytimes.com/services/xml/rss/nyt/Business.xml";
            }
            else if("Technology".equals(abc))
            {
                url="http://rss.nytimes.com/services/xml/rss/nyt/Technology.xml";
            }
            else if("World News".equals(abc))
            {
                url="http://rss.nytimes.com/services/xml/rss/nyt/World.xml";
            }
            else if("Sports".equals(abc1))
            {
                url="http://rss.nytimes.com/services/xml/rss/nyt/Sports.xml";
            }
            else if("Science".equals(abc1))
            {
                url="http://rss.nytimes.com/services/xml/rss/nyt/Science.xml";
            }
            else if("Health".equals(abc1))
            {
                url="http://rss.nytimes.com/services/xml/rss/nyt/Health.xml";
            }
            else
            {
                out.print("error page");
                return;
            }
            ServletContext context = getServletContext();                       
            InputStream xsl = (InputStream)
                        (context.getResourceAsStream("/anoop123.xsl"));
                   
    // We need two source objects and one result
    // get an external xml document using a url in a 
    // string format
    Source xmlDoc =  new StreamSource(url);
        
    Source xslDoc =  new StreamSource(xsl);
    Result result =  new StreamResult(out);
    // Prepare to transform 
    TransformerFactory factory = TransformerFactory.newInstance();
    Transformer trans = factory.newTransformer(xslDoc);
    trans.transform(xmlDoc,result);
   
           
//            out.println("<!DOCTYPE html>");
//            
//            out.println("<html>");
//            out.println("<head>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>You have selected " + result + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        }catch (TransformerConfigurationException ex) {
            Logger.getLogger(newsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(newsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            out.close();
        }
    }
}