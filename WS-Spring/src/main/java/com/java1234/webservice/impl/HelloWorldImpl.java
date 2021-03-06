package com.java1234.webservice.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.java1234.entity.Role;
import com.java1234.entity.User;
import com.java1234.webservice.HelloWorld;

@Component("helloWorld")
@WebService
public class HelloWorldImpl implements HelloWorld{
	//简单类型
	public String say(String str) {
		return "Hello:"+str;
	}
	//javabean返回list类型  一个用户对应的所有角色
	public List<Role> getRoleByUser(User user) {
		List<Role> roleList=new ArrayList<Role>();
		// 模拟  直接写死
		if(user!=null){
			if(user.getUserName().equals("java1234") && user.getPassword().equals("123456")){
				roleList.add(new Role(1,"技术总监"));
				roleList.add(new Role(2,"架构师"));
			}else if(user.getUserName().equals("jack") && user.getPassword().equals("123456")){
				roleList.add(new Role(3,"程序员"));
			}
			return roleList;
		}else{
			return null;
		}
	}

	//多个用户对应的所有角色
	public Map<String, List<Role>> getRoles() {
		Map<String,List<Role>> map=new HashMap<String,List<Role>>();
		
		List<Role> roleList1=new ArrayList<Role>();
		roleList1.add(new Role(1,"技术总监"));
		roleList1.add(new Role(2,"架构师"));
		
		map.put("java1234", roleList1);
		
		List<Role> roleList2=new ArrayList<Role>();
		
		roleList2.add(new Role(3,"程序员"));
		
		map.put("jack", roleList2);
		
		return map;
	}

}
