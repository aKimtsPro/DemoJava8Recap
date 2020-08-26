package demoLayeredArchitecture.business;

import demoLayeredArchitecture.business.mapper.PersonneMapper;
import demoLayeredArchitecture.business.model.PersonneDTO;
import demoLayeredArchitecture.dao.PersonneDAO;

public class PersonneService {

    private PersonneDAO dao = new PersonneDAO();

    public PersonneDTO getById(int id){
        return PersonneMapper.toDto( dao.getById(id) );
    }

}
