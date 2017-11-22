package com.curdoperation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import com.curdoperation.bo.UserBo;

@Component
public class UserDao {
   @Autowired
	 private NamedParameterJdbcTemplate npJdbcTemplate;
	private final String SQL_INSERT_SAVEUSER="INSERT INTO USER_TBL(USER_FNAME, USER_LNAME, GENDER,STATE,ZIP, MOBILE, EMAIL, PASSWORD) VALUES(:fName,:lName,:gender,:state,:zip,:mobile,:email,:password)";
     private final String SQL_FIND_USER_BY_EMAIL="SELECT USER_FNAME,USER_LNAME,GENDER,STATE,ZIP,MOBILE,EMAIL,PASSWORD FROM USER_TBL WHERE EMAIL= :email";
    private final String SQL_GET_USERS="SELECT USER_FNAME,USER_LNAME,GENDER,STATE,ZIP,MOBILE,EMAIL,PASSWORD FROM USER_TBL";
     private GeneratedKeyHolder kh;
     
     public long saveUser(UserBo bo){
    	 kh=new GeneratedKeyHolder();
    	 BeanPropertySqlParameterSource  params=new BeanPropertySqlParameterSource(bo);
    	 npJdbcTemplate.update(SQL_INSERT_SAVEUSER, params, kh);
    	return (long) kh.getKey();
    	 
     }
     
     public UserBo findUser(String email){
    	return npJdbcTemplate.queryForObject(SQL_FIND_USER_BY_EMAIL, new MapSqlParameterSource().addValue("email", email),new RowMapper<UserBo>(){

			@Override
			public UserBo mapRow(ResultSet rs, int count) throws SQLException {
				UserBo ubo=new UserBo();
				ubo.setfName(rs.getString(1));
				ubo.setlName(rs.getString(2));
				ubo.setGender(rs.getString(3));
				ubo.setState(rs.getString(4));
				ubo.setZip(rs.getString(5));
				ubo.setMobile(rs.getString(6));
				ubo.setEmail(rs.getString(7));
				ubo.setPassword(rs.getString(8));
				return ubo;
			}});
     }
     
     public List<UserBo> getUsers(){
    	 
    	 return npJdbcTemplate.query(SQL_GET_USERS,(rs,count)->{
    			UserBo ubo=new UserBo();
    			ubo.setfName(rs.getString(1));
    			ubo.setlName(rs.getString(2));
    			ubo.setGender(rs.getString(3));
    			ubo.setState(rs.getString(4));
    			ubo.setZip(rs.getString(5));
    			ubo.setMobile(rs.getString(6));
    			ubo.setEmail(rs.getString(7));
    			ubo.setPassword(rs.getString(8));
    			return ubo;
    			
    		});
     }
	/*RowMapper<UserBo> rowmap=(rs,count)->{
		UserBo ubo=new UserBo();
		ubo.setfName(rs.getString(1));
		ubo.setlName(rs.getString(2));
		ubo.setGender(rs.getString(3));
		ubo.setState(rs.getString(4));
		ubo.setZip(rs.getString(5));
		ubo.setMobile(rs.getString(6));
		ubo.setEmail(rs.getString(7));
		ubo.setPassword(rs.getString(8));
		return ubo;
		
	};*/
}
