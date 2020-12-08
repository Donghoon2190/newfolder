package Service;

import static Dao.DataAccessObject.*;
import static Db.JdbcUtil.*;

import java.sql.Connection;

import Dao.DataAccessObject;
import Dto.UserInfoBean;

public class Access {
	DataAccessObject dao;
	Connection con;
	
	public Access() {
	 dao = getInstance();
	 con = getConnection();
	dao.setConnection(con);
	}

	public boolean enterance(int request,UserInfoBean uib, String id) {
		boolean result = false;
		switch (request) {
		case 1: 
			result = this.login(uib,id);
		break;
		
		case 2: 
			this.logout(uib,id);
		break;
		}
		return result;
	}

	private boolean login(UserInfoBean uib,String id) {
		boolean result=false;
		if (dao.CheckId(uib)==1) {// 아이디 비교
			if (dao.CheckPwd(uib)==1) { // 아이디 비번 동시비교
				//히스토리 등록 후 커밋
				dao.SetLogin(uib,id);
				commit(con);
				dao.GetUserInfo(uib); // 로그인 성공시 회원정보 가져오기
				
				if (uib.getUserNickname()!=null) { 
					result = true;// 정보를 가져왔으면 트루 리턴
				}
			}
		}
		
		close(con);
		return result;
	}
	private void logout(UserInfoBean uib,String id) {
		dao.SetLogin(uib,id);
		commit(con);
		close(con);
		
	}

}











