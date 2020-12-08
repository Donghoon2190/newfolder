package Service;

import static Dao.DataAccessObject.*;
import static Db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import Dao.DataAccessObject;
import Dto.StoreInfoBean;

public class StoreService {

	DataAccessObject dao;
	Connection con;
	public StoreService() {
		dao = getInstance();
		con = getConnection();
		dao.setConnection(con);
	}
	
	public int enterance(int request,int start,int end,StoreInfoBean sib,ArrayList<StoreInfoBean> Rlist) {
		int result = 0;
		switch (request) {
		case 1:
			result=StoreReg(sib);
			break;

		case 2:
			RStoreInfo(Rlist);
			break;
		case 3:
			LStoreInfo(Rlist,start,end);
			break;
		case 4:
			result=StoreCount();
			break;
		}
		return result;
	}
	
	   private int StoreCount() {
		   int result=0;
		   result=dao.StoreCount();
		   
		   return result;
	}

	private void LStoreInfo(ArrayList<StoreInfoBean> Llist,int start,int end) {
		   dao.getLtoreInfo(Llist,start,end);
		   close(con);
	}

	private void RStoreInfo(ArrayList<StoreInfoBean> rlist) {
		   dao.getRStoreInfo(rlist);
		   
	}

	private int StoreReg(StoreInfoBean sib) {
		      int result = 0;
		      
		      String zip = "ICND%";
		      String currentStoreCode = dao.getStoreCode(zip);
		      
		      String code = currentStoreCode.substring(0,4);
		      String number = currentStoreCode.substring(4);
		      
		      
		      number = (Integer.parseInt(number)+1)+"";
		      
		      for (int i = number.length(); i < 3; i++) {
		         number = "0" + number;
		      }
		      sib.setStoreCode(code+number);
		      
		      result=dao.StoreReg(sib)==true?1:0;
		      if (result==1) {
				commit(con);
			}else {
				rollback(con);
			}
		      close(con);
		      return result;
		   }
}















