package components;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/interest")
public class InterestServlet extends HttpServlet
 {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
    {
        double principle = Double.parseDouble(request.getParameter("Principal"));
        double rate = Double.parseDouble(request.getParameter("Rate"));
        int time = Integer.parseInt(request.getParameter("Time"));
      double interest=principle*rate*time*0.01;
        
        
        
        if(principle == 0 && rate ==0 && time ==0){
            response.sendRedirect("formpost");
            return;
        }
        //var session = request.getSession(true);
        response.setContentType("text/html");
        var out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>DemoApp</title></head>");
        out.println("<body>");
        out.println("<h1>Hello Invester</h1>");
        out.printf("<b>Principal: </b>%.2f%n", principle);
        out.printf("<br><b>Rate: </b>%.2f%n", rate);
        out.printf("<br><b>Time in years: </b>%d%n", time);
        out.printf("<br><b>SI Interest: </b>%.2f%n", interest);
        out.println("</body>");
        out.println("</html>");
       
    }
}
