package demoLayeredArchitecture.business;

import demoLayeredArchitecture.business.mapper.ChienMapper;
import demoLayeredArchitecture.business.model.ChienDTO;
import demoLayeredArchitecture.dao.ChienDAO;
import demoLayeredArchitecture.dao.model.Chien;

import java.util.List;
import java.util.stream.Collectors;

public class ChienService {

    private ChienDAO dao = new ChienDAO();

    public void create(ChienDTO chien){

        dao.insert(ChienMapper.toEntity( chien ));

    }

    public List<ChienDTO> getAll(){

        return dao.getAll().stream()
                .map(ChienMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(int id){
        dao.delete( id );
    }

    public List<Chien> getWithFirstLetter(char firstLetter)
    {
        return dao.getAll()
                .stream()
                .filter(chien -> chien.getNom().toCharArray()[0] == firstLetter)
                .collect(Collectors.toList());
    }
}
