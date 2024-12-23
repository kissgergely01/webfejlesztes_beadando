package hu.unideb.inf.autokereskedes.service;

import hu.unideb.inf.autokereskedes.service.dto.AutoDto;

import java.util.Date;
import java.util.List;

public interface AutoManagementService {

    AutoDto findById(Long id);
    List<AutoDto> findAll();
    void deleteById(Long id);
    AutoDto save(AutoDto esemenyDto);

    List<AutoDto> findAllByGyartoKod(String gyarto);
    List<AutoDto> findAllByGyartoDb(String gyarto);
    List<AutoDto> findAllByAny(String gyarto,
                               String model,
                               Double evjarat,
                               Double ar);

}
