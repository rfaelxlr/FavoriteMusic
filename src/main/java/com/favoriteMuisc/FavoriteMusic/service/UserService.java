package com.favoriteMuisc.FavoriteMusic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.favoriteMuisc.FavoriteMusic.domain.Data;
import com.favoriteMuisc.FavoriteMusic.domain.User;
import com.favoriteMuisc.FavoriteMusic.dto.UserNewDTO;
import com.favoriteMuisc.FavoriteMusic.repository.DataRepository;
import com.favoriteMuisc.FavoriteMusic.repository.UserRepository;
import com.favoriteMuisc.FavoriteMusic.service.exceptions.DataIntegrityException;
import com.favoriteMuisc.FavoriteMusic.service.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private DataRepository dataRepo;
	
	@Autowired
	private BCryptPasswordEncoder pe;

	public List<User> findAll() {

		return repo.findAll();
	}

	public User find(Integer id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
	}
	
	public User fromDTO(UserNewDTO objDTO) {

		User user = new User(null, objDTO.getUsername(), objDTO.getEmail(), pe.encode(objDTO.getPassword()));

		return user;
	}

	@Transactional
	public User insert(User obj) {
		obj.setId(null);
		obj = repo.save(obj);
		
		Data data = new Data(obj);
		data.setId(null);
		data = dataRepo.save(data);
		return obj;
	}

	public User update(User obj) {
		User newObj = find(obj.getId());

		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		User obj = find(id);
		try {
			repo.delete(obj);

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Não foi possível deletar o usuário");
		}

	}

	private void updateData(User newObj, User obj) {

		newObj.setUsername(obj.getUsername());
		newObj.setEmail(obj.getEmail());
		newObj.setPicture(obj.getPicture());

	}

	public User findByEmail(String email) {
		User obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(email);
		}
		return obj;
	}
}
