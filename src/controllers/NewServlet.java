package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// CSRF対策
	    request.setAttribute("_token", request.getSession().getId());
	    
	    // おまじないとしてのインスタンスを作成
	    request.setAttribute("message", new Task());
	    
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasklists/new.jsp");
        rd.forward(request, response);
        
        
//	    EntityManager em = DBUtil.createEntityManager();
//		em.getTransaction().begin();
//		
//		// Taskのインスタンスを生成
//		Task m = new Task();
//		
//		// mの各フィールドにデータを代入
//		String content = "Lesson16";
//		m.setContent(content);
//		
//		Timestamp currentTime = new Timestamp(System.currentTimeMillis());     // 現在の日時を取得
//        m.setCreated_at(currentTime);
//        m.setUpdated_at(currentTime);
//
//        // データベースに保存
//        em.persist(m);
//        em.getTransaction().commit();
//        
//        // 自動採番されたIDの値を表示
//        response.getWriter().append(Integer.valueOf(m.getId()).toString());
//        
//        em.close();
	}
}
