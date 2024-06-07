package com.System.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.System.Config.TrackExecutionTime;
import com.System.Model.User;

@Service
public class UserService {
	
	private List<User> listOfUsers =new ArrayList<>(List.of(new User("1", "Bennyk", "Benny1234", "Benny@email.com"),
															new User("2", "King", "1234", "boss@email.com"),
															new User("3", "Jessy", "chika", "chi@email.com")));
	
	
	public void addNewUser(User user) {
		listOfUsers.add(user);
		
	}
	
	//returns a list of users 
	//testing the trackExecution annotation
		//adding new user to the list
	@TrackExecutionTime
	public List<User> getAllUsers() {
		return listOfUsers ;
	}
	
	//gets a particular user by id
	public User getUserById(String id) {
        return listOfUsers.stream()
                          .filter(u -> u.getId().equals(id))
                          .findFirst()
                          .orElse(null);
    }

	//deletes a user resource by id
    public void deleteUser(String id) {
        listOfUsers = listOfUsers.stream()
                                 .filter(u -> !u.getId().equals(id))
                                 .collect(Collectors.toList());
    }

    //updates a user 
	public boolean updateUser(User user, String id) {
		for(int i = 0; i < listOfUsers.size(); i++) {
			User u = listOfUsers.get(i); 
			if(user.getId().equals(id)) {
				listOfUsers.set(i, user);
				return true;
			}
			else
				return false;
		}
		return false;
	}
    
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
