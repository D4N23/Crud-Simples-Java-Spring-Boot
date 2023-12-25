package com.crudsimples.CrudSimples.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="TB_PARTNERS")
public class PartnersModel implements Serializable {
    private  static  final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idpartner;
    private String firstname;
    private String lastname;
    private Integer partnertype;
    private String cpf;
    private Boolean active = true;



//    public UUID getIdPartner() {
//        return idpartner;
//    }
//
//    public void setIdPartner(UUID idPartner) {
//        this.idpartner = idPartner;
//    }
//
//    public String getFisrtName() {
//        return firstname;
//    }
//
//    public void setFisrtName(String fisrtName) {
//        this.firstname = fisrtName;
//    }
//
//    public String getLastName() {
//        return lastname;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastname = lastName;
//    }
//
//    public Integer getPartnerType() {
//        return partnertype;
//    }
//
//    public void setPartnerType(Integer partnerType) {
//        this.partnertype = partnerType;
//    }
//
//    public String getCpf() {
//        return cpf;
//    }
//
//    public void setCpf(String cpf) {
//        cpf = cpf;
//    }
//
//    public Boolean getActive() {
//        return active;
//    }
//
//    public void setActive(Boolean active) {
//        this.active = active;
//    }
}
