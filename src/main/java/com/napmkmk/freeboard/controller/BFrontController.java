package com.napmkmk.freeboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.napmkmk.freeboard.command.BCommand;
import com.napmkmk.freeboard.command.BListCommand;
import com.napmkmk.freeboard.command.BWriteCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri  = request.getRequestURI();// 클라이언트가 요청한 uri 전부 가져오기
		String conPath = request.getContextPath(); //cont text path 가져오기
		String comm = uri.substring(conPath.length()); //전체 URI 에서 context 경로 길이 만큼 빼줌
		
		BCommand command = null;
		
		if(comm.equals("/write.do")) {
			System.out.println("write.do 요청");
			
			command = new BWriteCommand();
			command.execute(request, response);
		}   else if (comm.equals("/list.do")){
			System.out.println("list.do 요청");
			
			command = new BListCommand();
			command.execute(request, response);
			//request 객체에 글리스트가 완료 어디로 보내줄까 대기 완료.
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp"); //jsp파일에 전부 보내주는것.
			dispatcher.forward(request, response);
		}
	}

}
