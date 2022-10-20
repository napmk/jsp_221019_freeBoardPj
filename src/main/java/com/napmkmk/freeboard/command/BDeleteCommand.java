package com.napmkmk.freeboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.napmkmk.freeboard.dao.BoardDao;
import com.napmkmk.freeboard.dto.BoardDto;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse repResponse) {
		// TODO Auto-generated method stub
		
		String bid = request.getParameter("bid");
		BoardDao dao = new BoardDao();
		dao.delete(bid);
		
		
	}

}
