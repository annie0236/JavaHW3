package service;

import model.Member;

public interface MemberService {
	//create
	boolean addMember(Member member);//判斷帳號+新增
	
	
	//read
	Member login(String username,String password);//登入
	
	//update
	
	//delete

}
