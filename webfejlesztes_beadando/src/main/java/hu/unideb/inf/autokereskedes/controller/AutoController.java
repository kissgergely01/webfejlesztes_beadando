package hu.unideb.inf.autokereskedes.controller;

import hu.unideb.inf.autokereskedes.service.AutoManagementService;
import hu.unideb.inf.autokereskedes.service.dto.AutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController//json-t küld, json-t fogad
@RequestMapping("/api")
public class AutoController {

    @Autowired
    AutoManagementService service;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/hw")
    public ResponseEntity<String> helloworld(){
        return new ResponseEntity<>("Hello, world!", HttpStatus.NOT_FOUND);
    }

    // localhost:8080/api/saveauto
    //CREATE
    @PostMapping("/saveauto")
    public AutoDto save(@RequestBody AutoDto dto){
        return service.save(dto);
    }

    // localhost:8080/api/updateauto
    //UPDATE
    @PutMapping("/updateauto")
    public AutoDto update(@RequestBody AutoDto dto) {
        if (dto.getId() > 0L) {
            // Assuming service.save() is doing an insert, we should check for existing car and update it
            Optional<AutoDto> existingAuto = Optional.ofNullable(service.findById(dto.getId()));
            if (existingAuto.isPresent()) {
                // Perform update on existing car (update the necessary fields)
                AutoDto autoToUpdate = existingAuto.get();
                autoToUpdate.setGyarto(dto.getGyarto());
                autoToUpdate.setModel(dto.getModel());
                autoToUpdate.setEvjarat(dto.getEvjarat());
                autoToUpdate.setAr(dto.getAr());

                // Save updated car
                return service.save(autoToUpdate);
            }
        }
        return null;
    }

    // localhost:8080/api/auto?id=1
    //DELETE
    @DeleteMapping("/deleteauto")
    public void delete(@RequestParam Long id){
        service.deleteById(id);
    }

    @GetMapping("/autok")
    public List<AutoDto> findAll(){
        return service.findAll();
    }

    //localhost:8080/api/auto/mazda
    @GetMapping("/auto/{gyarto}")
    public List<AutoDto> findAllByGyarto(@PathVariable String gyarto){
        return service.findAllByGyartoKod(gyarto);
    }

    //localhost:8080/api/autobygyarto?gyarto=mazda
    @GetMapping("/autobygyarto")
    public List<AutoDto> findAllByGyartoRp(@RequestParam String gyarto){
        return service.findAllByGyartoDb(gyarto);
    }

    @GetMapping("/filterauto")
    public List<AutoDto> filterEsemeny(@RequestParam(required = false) String gyarto,
                                       @RequestParam(required = false) String model,
                                       @RequestParam(required = false)Double evjarat,
                                       @RequestParam(required = false) Double ar){
        return service.findAllByAny(gyarto,model,evjarat,ar);
    }
}
