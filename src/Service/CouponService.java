package Service;

import static Dao.DataAccessObject.*;
import static Db.JdbcUtil.*;

import java.sql.Connection;

import Dao.DataAccessObject;
import Dto.UserInfoBean;

public class CouponService {

		DataAccessObject dao;
		Connection con;
		
		public CouponService() {
		 dao = getInstance();
		 con = getConnection();
		dao.setConnection(con);
		}

		public boolean enterance(int request,String id, String coupon) {
			boolean result = false;
			switch (request) {
			case 1:
				result = CouponReg(id,coupon);
				System.out.println(result+"인터런스");
				break;

			default:
				break;
			}
			return result;
		}


	public boolean CouponReg(String id, String coupon) {
		boolean result = false;
		if (dao.CouponCheck(id,coupon)) {
			result=dao.CouponReg(id,coupon);
			if (result) {
				commit(con);
			}else {
				rollback(con);
			}
		}
		System.out.println(result+"서비스");
		close(con);
		return result;
	}
}








