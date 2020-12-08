package Service;

import static Dao.DataAccessObject.*;
import static Db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import Dao.DataAccessObject;
import Dto.BoardInfoBean;
import Dto.pageInfoBean;

public class CommunityService {
	DataAccessObject dao;
	Connection con;
	public CommunityService() {
		dao = getInstance();
		con = getConnection();
		dao.setConnection(con);
	}
	public int enterance(int requset ,int start,int end,ArrayList<BoardInfoBean> list,BoardInfoBean bib) {
		int result=0;
		switch (requset) {
		case 1: // 게시글 갯수 가져오기
			result=CommunityCount();
			break;
			
		case 2: // 페이지마다 게시글 불러오기
			CommunityList(start,end,list);
			break;
			
		case 3: // 다른거 쓰면됨
			
			break;
			
		case 4: // 게시글 수정
			result=CommunityMod(bib);
			break;
			
		case 5: // 게시글 삭제
			result=CommunityDel(start);
			break;
			
		case 6: // 게시글 등록
			result=CommunityWrite(bib);
			break;
		case 7: // 좋아요 탑3 가져오기
			GetTop3(list);
			break;
		case 8: // 좋아요 카운트
			result=TumbsCount(bib);
			break;
		}
		return result;
	}
	
	// 오버로딩
	public boolean enterance(int requset, pageInfoBean pib, BoardInfoBean bib, ArrayList<BoardInfoBean> reList) {
		boolean result = false;
		switch (requset) {
		case 1: // 댓글쓰기
			result = insertReply(bib);
			break;
			
		case 2: // 댓글 삭제하기
			result = deleteReply(bib);
			break;
			
		case 3: // 댓글 조회하기 및 상세보기
			result = getReply(pib,bib,reList);
			break;
			
		}
		return result;
	}
	
	// 댓글 등록
	private boolean insertReply(BoardInfoBean bib) {
		boolean result = false;
		if(dao.insertReply(bib)) {
			commit(con);
			result = true;
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}
	// 댓글 삭제
	private boolean deleteReply(BoardInfoBean bib) {
		boolean result = false;
		if(dao.deleteReply(bib)) {
			commit(con);
			result = true;
		}else {
			rollback(con);
		}
		close(con);
		return result;
	}
	// 댓글 조회
	private boolean getReply(pageInfoBean pib ,BoardInfoBean bib,ArrayList<BoardInfoBean> reList) {
		boolean result = false;
		
		dao.OneCommunityView(pib.getBoardNum(),bib);
		dao.getTotalReply(pib);
		if(dao.getReply(pib,reList)) {
			commit(con);
			result = true;
		}else {
			rollback(con);
		}
		close(con);
		return result;
	}
	
	private int TumbsCount(BoardInfoBean bib) {
		int result = 0;
		
		if (dao.CheckCount(bib)) {
			result=dao.ThumbsCount(bib);
			
			if (result==1) {
				commit(con);
			}else {
				rollback(con);
			}
		}
		
	
		close(con);
		
		return result;
	}
	// 게시글 갯수 가져오기
	private int CommunityCount() {
		dao = getInstance();
		con = getConnection();
		dao.setConnection(con);
		int listCount = dao.CommunityCount();
		close(con);

		return listCount;
	}

	// 게시글 페이지로 불러오기
	private void CommunityList(int startRow, int endRow,ArrayList<BoardInfoBean> list) {
		dao = getInstance();
		con = getConnection();
		dao.setConnection(con);
		
		dao.CommunityList(startRow, endRow,list);
		
		close(con);
		
	}
	// 게시글 상세보기
	private void OneCommunityView(int bNum,BoardInfoBean bib) {
		dao.OneCommunityView(bNum,bib);
		close(con);
	}
	// 게시글 수정
	private int CommunityMod(BoardInfoBean bib) {
		int proResult = dao.CommunityMod(bib);
		
		if(proResult>0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return proResult;
	}
	//게시글 삭제
	private int CommunityDel(int bNum) {
		int delResult = dao.CommunityDel(bNum);

		if(delResult>0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return delResult;
	}
	//게시글 작성
	private int CommunityWrite(BoardInfoBean board) {
		int writeResult = dao.CommunityWrite(board);
		
		if(writeResult>0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return writeResult;
	}

	private void GetTop3(ArrayList<BoardInfoBean> list) {
	
		dao.GetTop3(list);
		close(con);
		
	}
}




