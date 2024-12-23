package hu.unideb.inf.autokereskedes.service.impl;

import hu.unideb.inf.autokereskedes.data.entity.AutoEntity;
import hu.unideb.inf.autokereskedes.data.repository.AutoRepository;
import hu.unideb.inf.autokereskedes.service.AutoManagementService;
import hu.unideb.inf.autokereskedes.service.dto.AutoDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AutoManagementServiceImpl implements AutoManagementService {

    @Autowired
    AutoRepository repo;
    @Autowired
    ModelMapper mapper;

    @Override
    public AutoDto findById(Long id) {
        AutoEntity entity = repo.getReferenceById(id);
        AutoDto dto = new AutoDto();

        dto.setId(entity.getId());
        dto.setGyarto(entity.getGyarto());
        dto.setModel(entity.getModel());
        dto.setEvjarat(entity.getEvjarat());
        dto.setAr(entity.getAr());

        return dto;
    }

    @Override
    public List<AutoDto> findAll() {
        List<AutoEntity> entities = repo.findAll();
        List<AutoDto> dtos = new ArrayList<>();
        dtos = mapper.map(entities, new TypeToken<List<AutoDto>>(){}.getType());
        return dtos;
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public AutoDto save(AutoDto esemenyDto) {
        AutoEntity entity = mapper.map(esemenyDto, AutoEntity.class);
        entity = repo.save(entity);
        AutoDto dto = mapper.map(entity, AutoDto.class);

        return dto;
    }

    @Override
    public List<AutoDto> findAllByGyartoKod(String gyarto) {
        List<AutoEntity> szurt = new ArrayList<>();

        szurt = repo.findAll()
                .stream()
                .filter(x -> x.getGyarto().contains(gyarto))
                .toList();

        return mapper.map(szurt, new TypeToken<List<AutoDto>>(){}.getType());
    }

    @Override
    public List<AutoDto> findAllByGyartoDb(String gyarto) {
        return mapper.map(repo.findAllByGyartoContains(gyarto), new TypeToken<List<AutoDto>>(){}.getType());
    }

    @Override
    public List<AutoDto> findAllByAny(String gyarto, String model, Double evjarat, Double ar) {
        List<AutoEntity> szurt = new ArrayList<>();

        szurt = repo.findAll()
                .stream()
                .filter(x -> gyarto == null || x.getGyarto().equals(gyarto))
                .filter(x -> model == null || x.getModel().equals(model))
                .filter(x -> evjarat == null || x.getEvjarat().equals(evjarat))
                .filter(x -> ar == null || x.getAr().equals(ar))
                .toList();

        return mapper.map(szurt, new TypeToken<List<AutoDto>>(){}.getType());
    }
}
