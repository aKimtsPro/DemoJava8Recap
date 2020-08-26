package demoLayeredArchitecture.business.mapper;

import demoLayeredArchitecture.business.model.PersonneDTO;
import demoLayeredArchitecture.dao.model.Personne;

public class PersonneMapper {

    public static PersonneDTO toDto(Personne personne){
        return new PersonneDTO(personne.getId(), personne.getNom());
    }

    public static Personne toEntity(PersonneDTO dto){

        Personne entity = new Personne();

        entity.setId( dto.getId() );
        entity.setNom( dto.getNom() );

        return entity;
    }

}
