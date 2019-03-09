package com.brainmentor.testengine.user.Dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;

import com.brainmentor.testengine.user.DTO.RightDTO;
import com.brainmentor.testengine.user.DTO.UserDTO;
import com.brainmentor.testengine.util.common.CommonDAO;
import com.brainmentor.testengine.util.contant.Query;

public class userDAO {
	


private Category logger;



public  UserDTO doLogin(String userid,String password) throws SQLException, ClassNotFoundException {
	
	
	Logger logger = Logger.getLogger(userDAO.class);
	UserDTO userdto=null;
			
	Connection connection=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	ArrayList<RightDTO>right=null;  
	try {
		logger.debug("connection is make");
	connection=CommonDAO.getConnection();
	
	pstmt =connection.prepareStatement(Query.NEW_SQL);
	
	pstmt.setString(1, userid);
	pstmt.setString(2,password);
	
	rs = pstmt.executeQuery();
	logger.debug("query execute");
	while(rs.next()) {
		if(userdto==null){

		userdto = new UserDTO();

			userdto.setUserName(rs.getString("userid"));

			userdto.setRoleName(rs.getString("rolename"));

			right = new ArrayList<>();

			userdto.setRights(right);

			

		}

		RightDTO rights = new RightDTO(rs.getString("rightname"),rs.getString("screenname"));

		right.add(rights);
		
	}
	
	//if(rs.next())
//	{`
    //     return "welcone"+userid;
         
//	}
	
      //   else
     //    { 

	
     //   	 return "invalid or password";
         
    //     }

	} 
	finally {
		logger.debug("finally");
	if (rs!= null)
	{
		rs.close();
	
	}

	
	
	if (pstmt!=null)
	{ pstmt.close();
	}
	
	if(connection!=null)
	{ connection.close();}
	

	}
	return userdto;
}



private boolean hasNext() {
	// TODO Auto-generated method stub
	return false;
}



public String doRegister(UserDTO userDTO) throws SQLException, ClassNotFoundException {
	Connection connection = null;

	PreparedStatement pstmt = null;

	try{

		connection = CommonDAO.getConnection();
		 System.out.println("working6");


		pstmt = connection.prepareStatement(Query.REGISTER_SQL);
		 System.out.println("working7");


		pstmt.setString(1,userDTO.getUserName());

		pstmt.setString(2, userDTO.getPassword());
		 System.out.println("working.....");

		pstmt.setString(4,userDTO.getAddress());
       pstmt.setString(5, userDTO.getGender());
       pstmt.setString(3,userDTO.getPinCode());
		 System.out.println("working8");

	//	 pstmt.setString(5,userDTO.getSetSimpleDateFormat());

		int insertedCount = pstmt.executeUpdate();
		 System.out.println("working9");


		return insertedCount>0?"Register SuccessFully":"Can't Register";

		
	

	}

	finally{

		//logger.debug("Inside Finally ");

		

		

		if(pstmt!=null){

		pstmt.close();

		}

		if(connection!=null){

		connection.close();

		}

	}


	

	
	
	// TODO Auto-generated method stub
	
}
}