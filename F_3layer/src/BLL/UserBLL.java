package BLL;

import java.sql.ResultSet;

import DAL.UserDAL;
import DTO.UserDTO;

public class UserBLL {
	UserDAL userDAL;
	public ResultSet login(UserDTO userDTO) {
		ResultSet result=null;
		if (userDTO.getUserName().equals(""))
			return result;
		else if(userDTO.getPassword().equals(""))
			return result;
		else {
			userDAL=new UserDAL();
			result= userDAL.getUserIDByNameNPass(userDTO);
		}
		return result;
	}
}
