package demoLayeredArchitecture.business.mapper;

import demoLayeredArchitecture.business.PersonneService;
import demoLayeredArchitecture.business.model.ChienDTO;
import demoLayeredArchitecture.dao.model.Chien;

public class ChienMapper {

    private static PersonneService service = new PersonneService();

    public static ChienDTO toDTO(Chien entity)
    {
        return new ChienDTO(
                entity.getId(),
                entity.getNom(),
                service.getById( entity.getProprioId() )
        );
    }

    public static  Chien toEntity(ChienDTO dto)
    {
        Chien rslt = new Chien();

        rslt.setId( dto.getId() );
        rslt.setNom( dto.getNom() );
        rslt.setProprioId( dto.getProprio().getId() );

        return rslt;
    }
}
