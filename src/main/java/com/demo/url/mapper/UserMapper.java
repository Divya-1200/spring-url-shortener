package com.demo.url.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.demo.url.model.User;
import com.demo.url.model.UserUrl;
import java.util.List;
//import antlr.collections.List;


@Mapper
public interface UserMapper {
	
	@Insert("insert into user (username, password) values (#{name}, #{password})") 
	void insertUser(@Param("name")String name , @Param("password") String password);
	
	@Insert("insert into url (username, shorturl, url) values (#{name}, #{shorturl}, #{url})") 
	void inserturl(@Param("name")String name , @Param("shorturl") String shorturl, @Param("url") String url );
	
	@Select("select url from url where username = #{name} and shorturl = #{shorturl}")
	String findurl(@Param("name") String name, @Param("shorturl") String shorturl);
	
	
	@Update("update atm set amount = amount + #{amount} where username = #{name}")
	void depositBalance(@Param("name") String name, @Param("amount") int amount);
	
	@Select("select * from user where username = #{name} and password = #{password}")
	User findByUser(@Param("name") String name, @Param("password") String password);
	
	@Select("select * from url where username = #{name}")
	List<UserUrl> findUrl(@Param("name") String name);
	
	@Update("update atm set amount = amount - #{amount} where username = #{name}")
	void withdrawBalance(@Param("name") String name, @Param("amount") int amount);
	
	@Select("select * from admin where username = #{name} and password = #{password}")
	User findByAdmin(@Param("name") String name, @Param("password") String password);
	
	@Select("select atmbalance from atmbalance where atm = 'zoho'")
	int findAtmBalance();
	
	@Update("update atmbalance set atmbalance = atmbalance + #{amount} where atm='zoho'")
	void adminDepositBalance(@Param("amount") int amount);
	
	@Update("update atmbalance set atmbalance = atmbalance - #{amount} where atm = 'zoho'")
	void adminWithdrawBalance(@Param("amount") int amount);
	
	
	
	
	
}
