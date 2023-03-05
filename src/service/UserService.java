package service;

import java.util.List;

import database.UserDao;
import model.User;

public class UserService {
	private UserDao userDao;
	
	public UserService(UserDao userDao){
		this.userDao= userDao;
	}
	
	public void userLogin(String userName, String password){
		if(userDao.logIn(userName, password)){
			System.out.println("User "+userName+" Logged In");
		}
		else{
			throw new RuntimeException("User Name or Password is incorrect");
		}
	}
	public User getUser(String userName, String password){
		if(userDao.logIn(userName, password)){
			return userDao.getUser(userName, password);
		}
		else{
			throw new RuntimeException("User Name or Password is incorrect");
		}
	}
	
	public void createUser(User user){
		if(userDao.createUser(user)){
			System.out.println("User created");
		}else{
			throw new RuntimeException("User not created due to some problem");
		}
	}
	
	public void getAllUsers(){
		List<User> users= userDao.getAllUsers();
		for(User user: users){
			System.out.println(user.toString());
		}
	}

}
