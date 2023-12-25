package com.crudsimples.CrudSimples.controllers;

import com.crudsimples.CrudSimples.dtos.PartnersRecordDto;
import com.crudsimples.CrudSimples.models.PartnersModel;
import com.crudsimples.CrudSimples.repositories.PartnersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/partners")
public class PartnersControllers {

    @Autowired
    private PartnersRepository repository;

    @PostMapping//("/partners")
    public ResponseEntity<PartnersModel> create(@RequestBody @Valid PartnersRecordDto partnerDTO){
      var active = true;
     var partnerModel = new PartnersModel();
     BeanUtils.copyProperties(partnerDTO, partnerModel);
     return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(partnerModel));
    }

    @GetMapping
    public ResponseEntity<List<PartnersModel>> getAllPartners(){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findByActiveTrue());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPartner(@PathVariable(value="id") UUID id){
        Optional<PartnersModel> optionalPartner = repository.findById(id);
        if(optionalPartner.isEmpty() || !optionalPartner.get().getActive()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NÃO ENCONTRADO");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalPartner.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePartner(@PathVariable(value = "id")UUID id,
                                                @RequestBody @Valid PartnersRecordDto partnersRecordDto){
        Optional<PartnersModel> optionalPartner = repository.findById(id);
        if(optionalPartner.isEmpty() || !optionalPartner.get().getActive()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Partner Não Encontrado");
        }
        var partnerModel = optionalPartner.get();
        BeanUtils.copyProperties(partnersRecordDto, partnerModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(partnerModel));
    }



    @DeleteMapping("{id}")
    public ResponseEntity<Object> desativePartiner(@PathVariable(value = "id") UUID id){
        Optional<PartnersModel> optionalPartner = repository.findById(id);
        if(optionalPartner.isEmpty() || !optionalPartner.get().getActive()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Partner Não Encontrado");
        }
        var partnerModel = optionalPartner.get();
        partnerModel.setActive(false);
        repository.save(partnerModel);
        return ResponseEntity.status(HttpStatus.OK).body("Partner Desativado  com Sucesso");
    }

    @PatchMapping("{id}")
    public ResponseEntity<Object> partialUpdatePartner(
                @PathVariable(value="id") UUID id,
                @RequestBody PartnersRecordDto partialRecordDto){

        Optional<PartnersModel> optionalPartner = repository.findById(id);
        if(optionalPartner.isEmpty() || !optionalPartner.get().getActive()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Partner Não Encontrado");
        }

         var partnerModel = optionalPartner.get();

        //Verificar existencia de informação previa nos campos
        if(partialRecordDto.firstname() != null){
            partnerModel.setFirstname(partialRecordDto.firstname());
        }
        if(partialRecordDto.lastname() != null){
            partnerModel.setLastname(partialRecordDto.lastname());
        }
        if(partialRecordDto.cpf() != null){
            partnerModel.setCpf(partialRecordDto.cpf());
        }
        if(partialRecordDto.partnertype() != null){
            partnerModel.setPartnertype(partialRecordDto.partnertype());
        }

        return ResponseEntity.status(HttpStatus.OK).body(repository.save(partnerModel));

    }

}
