package com.example.MicroservicesExample.ServiceLayer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.MicroservicesExample.Exceptions.UserNotFoundException;
import com.example.MicroservicesExample.Model.User;
@Service
public class UserDaoService {
	private static List<User> users = new ArrayList<User>();
	private static int usercount=0;
	static {
		users.add(new User(++usercount,"swap",LocalDate.now().minusYears(25)));
		users.add(new User(++usercount,"rachit",LocalDate.now().minusYears(45)));
		users.add(new User(++usercount,"ayushi",LocalDate.now().minusYears(35)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		user.setId(++usercount);
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		return users.stream().filter(user->user.getId()==id).findFirst().orElse(null);
	}
	
	public User deleteById(int id) {
		User user = findOne(id);
		 
		 if (user!=null) {
			 users.removeIf(x->x.getId()==id);
			 return user;
		 }
		 else {
			 throw new UserNotFoundException("no user present with given id");
		 }
	}
}
