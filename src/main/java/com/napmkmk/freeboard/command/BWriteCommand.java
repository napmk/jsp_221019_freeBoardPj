package com.napmkmk.freeboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.napmkmk.freeboard.dao.BoardDao;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse repResponse) {
		// TODO Auto-generated method stub

		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao dao = new BoardDao();
		dao.write(bname, btitle, bcontent);
	}

}
