package com.gamedoora.backend.userservices.assembler;

import com.gamedoora.model.dto.SourceDTO;
import com.gamedoora.backend.userservices.repository.SourcesRepository;
import com.gamedoora.model.dao.Sources;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gamedoora.model.mapper.SourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SourcesServicesAssembler {

  private SourcesRepository sourcesRepository;

  private SourceMapper sourceMapper;

  public SourcesRepository getSourcesRepository() {
    return sourcesRepository;
  }

  @Autowired
  public void setSourcesRepository(SourcesRepository sourcesRepository) {
    this.sourcesRepository = sourcesRepository;
  }

  public SourceMapper getSourceMapper() {
    return sourceMapper;
  }

  @Autowired
  public void setSourceMapper(SourceMapper sourceMapper){
    this.sourceMapper = sourceMapper;
  }

  public SourceDTO createSources(SourceDTO sourcesDto) {

    Sources sources = sourceMapper.sourceDtoToSources(sourcesDto);
    sourcesRepository.save(sources);
    return sourcesDto;
  }

  public SourceDTO updateSources(long id, SourceDTO sourcesDto) {

    Optional<Sources> sourcesRes = sourcesRepository.findById(id);
    if (!sourcesRes.isPresent()) {
      return null;
    }
    Sources sources = sourcesRes.get();
    sources.setName(sourcesDto.getName());

    sourcesRepository.save(sources);
    return sourcesDto;
  }

  public void deleteSources(long id) {
    getSourcesRepository().deleteById(id);
  }

  public void deleteAllSources() {
    getSourcesRepository().deleteAll();
  }

  public List<SourceDTO> getAllSources(String name) {
    List<SourceDTO> sourcesDto = new ArrayList<>();
    if (name == null) {
      sourcesRepository.findAll().forEach(sources -> sourcesDto.add(getSourceMapper().sourceToSourceDTO(sources)));
      return sourcesDto;
    }
    sourcesRepository.findByNameContaining(name).forEach(sources -> sourcesDto.add(getSourceMapper().sourceToSourceDTO(sources)));
    return sourcesDto;
  }
}
