package fp.main.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//
//import com.google.gson.JsonObject;

/**
 * Servlet implementation class GoKnowStepServlet
 */
@WebServlet(name = "GoKnowStep", urlPatterns = { "/goKnowStep" })
public class GoKnowStepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoKnowStepServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		JsonObject finalObject = new JsonObject();
//	    JSONArray templist = new JSONArray();
//	    JSONObject temp = new JSONObject();
//	    JSONObject temp2 = new JSONObject();
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/paper/knowStep.jsp");
		rd.forward(request, response);
//		temp.put("name", "q1");
//		temp.put("value", "Basil");
//		temp.put("type", "checkbox");
//		temp.put("html", "베르가못<br>Bergamot");
//		temp.put("src", "/choiceimg/note/Bergamot.jpg");
//		temp2.put(1,temp);
//		templist.add(temp2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
