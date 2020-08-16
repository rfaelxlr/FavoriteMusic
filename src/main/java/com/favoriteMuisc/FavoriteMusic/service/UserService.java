package com.favoriteMuisc.FavoriteMusic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.favoriteMuisc.FavoriteMusic.domain.User;
import com.favoriteMuisc.FavoriteMusic.repository.UserRepository;
import com.favoriteMuisc.FavoriteMusic.service.exceptions.DataIntegrityException;
import com.favoriteMuisc.FavoriteMusic.service.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	public List<User> findAll() {

		return repo.findAll();
	}

	public User find(Integer id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
	}

	@Transactional
	public User insert(User obj) {
		obj.setId(null);
		obj = repo.save(obj);
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
