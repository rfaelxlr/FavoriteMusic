package com.favoriteMuisc.FavoriteMusic.service.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.favoriteMuisc.FavoriteMusic.domain.User;
import com.favoriteMuisc.FavoriteMusic.dto.UserNewDTO;
import com.favoriteMuisc.FavoriteMusic.repository.UserRepository;
import com.favoriteMuisc.FavoriteMusic.resource.exceptions.FieldMessage;

public class UserInsertValidator implements ConstraintValidator<UserInsert, UserNewDTO>{
	
	@Autowired
	private UserRepository repo;

	@Override
	public boolean isValid(UserNewDTO objDto, ConstraintValidatorContext context) {
		
		
		
		List<FieldMessage> list = new ArrayList<>();
		
		
		User aux = repo.findByEmail(objDto.getEmail());
		if(aux != null) {
			list.add(new FieldMessage("email","Email já existente"));
		}
		
		

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();

	}

	

}
