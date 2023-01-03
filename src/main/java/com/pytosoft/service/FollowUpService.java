package com.pytosoft.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pytosoft.model.FollowUp;
import com.pytosoft.repository.FollowUpRepository;


@Service
public class FollowUpService {

	@Autowired
	private FollowUpRepository followUpRepository;

	public List<FollowUp> listAll() {
		return followUpRepository.findAll();
	}

	public FollowUp save(FollowUp followUp) {
		return followUpRepository.save(followUp);
	}

	public FollowUp getFollowUpById(Long id) {
		return followUpRepository.findById(id).get();
	}

	public void deleteById(Long id) {
		followUpRepository.deleteById(id);
	}

}
