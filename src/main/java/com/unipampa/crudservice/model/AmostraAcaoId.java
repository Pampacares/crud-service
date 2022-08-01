package com.unipampa.crudservice.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AmostraAcaoId implements Serializable {
    @Column(name="amostra_id")
    private UUID amostraId;

    @Column(name="sintoma_id")
    private UUID acaoId;
  
    public AmostraAcaoId(UUID amostraId, UUID acaoId){
        this.amostraId = amostraId;
        this.acaoId = acaoId;
    }
    
    public AmostraAcaoId(){
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((amostraId == null) ? 0 : amostraId.hashCode());
        result = prime * result + ((acaoId == null) ? 0 : acaoId.hashCode());
        return result;
    }
    
}
