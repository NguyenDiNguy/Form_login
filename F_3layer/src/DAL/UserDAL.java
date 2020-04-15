package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.UserDTO;
import UTILS.ConnectionUtil;

public class UserDAL {
	ResultSet result;
	Connection con;
	PreparedStatement preparedStatement;
	public ResultSet getUserIDByNameNPass(UserDTO userDTO){
		String sql="Select * form user where username=? and password=?";
		try {
			ConnectionUtil conUtil=new ConnectionUtil();
			con=conUtil.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, userDTO.getUserName());
			preparedStatement.setString(2, userDTO.getPassword());
			result = preparedStatement.executeQuery(sql);
		} catch(SQLException e){
			e.printStackTrace();	
			}
		finally {
			try {
				con.close();
				preparedStatement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
