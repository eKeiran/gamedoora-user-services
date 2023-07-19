package com.gamedoora.backend.userservices.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gamedoora.model.mapper.SkillsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamedoora.model.dto.SkillsDTO;
import com.gamedoora.backend.userservices.repository.SkillsRepository;
import com.gamedoora.model.dao.Skills;

@Component
public class SkillsServicesAssembler {

  private SkillsRepository skillsRepository;

  private SkillsMapper skillsMapper;

  public SkillsRepository getSkillsRepository() {
    return skillsRepository;
  }

  @Autowired
  public void setSkillsRepository(SkillsRepository skillsRepository) {
    this.skillsRepository = skillsRepository;
  }

  @Autowired
  public void setSkillsMapper(SkillsMapper skillsMapper){
    this.skillsMapper = skillsMapper;
  }

  public SkillsMapper getSkillsMapper(){
    return skillsMapper;
  }


  public SkillsDTO createSkills(SkillsDTO skillsDto) {

    Skills skills = skillsMapper.skillsDtoToSkills(skillsDto);
    skillsRepository.save(skills);
    return skillsDto;
  }

  public SkillsDTO updateSkills(long id, SkillsDTO skillsDto) {

    Optional<Skills> skillsRes = skillsRepository.findById(id);
    if (!skillsRes.isPresent()) {
      return null;
    }
    Skills skills = skillsRes.get();
    skills.setName(skillsDto.getName());
    skills.setDescription(skillsDto.getDescription());
    skillsRepository.save(skills);
    return skillsDto;
  }

  public void deleteSkills(long id) {
    getSkillsRepository().deleteById(id);
  }

  public void deleteAllSkills() {
    getSkillsRepository().deleteAll();
  }

  public List<SkillsDTO> getAllSkills(String name) {
    List<SkillsDTO> skillsDTOList = new ArrayList<>();
    if (name == null) {
      skillsRepository.findAll().forEach(skills -> skillsDTOList.add(getSkillsMapper().skillsToSkillsDTO(skills)));
      return skillsDTOList;
    }
    skillsRepository.findByNameContaining(name).forEach(skills -> skillsDTOList.add(getSkillsMapper().skillsToSkillsDTO(skills)));
    return skillsDTOList;
  }
}