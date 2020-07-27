package com.pabs.jee.restpm.skills;

import java.util.List;

import javax.inject.Inject;

public class SkillsService {
	@Inject
	SkillsRepository skillsRepository;

	public Skill findByName(String name) {
		return skillsRepository.findByName(name);
	}

	public List<Skill> findAll() {
		return skillsRepository.findAllOrderedByName();
	}

}
