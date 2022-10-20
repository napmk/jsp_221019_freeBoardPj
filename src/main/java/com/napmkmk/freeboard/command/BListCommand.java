package com.napmkmk.freeboard.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.napmkmk.freeboard.dao.BoardDao;
import com.napmkmk.freeboard.dto.BoardDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse repResponse) {
		// TODO Auto-generated method stub
		BoardDao dao = dao = new BoardDao();
		
		ArrayList<BoardDto> dtos = dao.list(); //리스트실행 리스트 받으면
		//dto들의 컬렌션인 dto(ArrayList타입)가 반환됨
		
		request.setAttribute("list", dtos); // 프론트로 전달?
	
	}

}
