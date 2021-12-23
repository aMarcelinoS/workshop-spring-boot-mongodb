package com.example.workshopmongosbjava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmongosbjava.domain.User;
import com.example.workshopmongosbjava.dto.UserDTO;
import com.example.workshopmongosbjava.repository.UserRepository;
import com.example.workshopmongosbjava.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return userRepository.insert(obj); 
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);		
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}	
}
