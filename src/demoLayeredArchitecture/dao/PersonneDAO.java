package demoLayeredArchitecture.dao;

import demoLayeredArchitecture.dao.model.Personne;
import demoLayeredArchitecture.outil.OutilPersonne;

import java.io.*;
import java.util.Optional;

public class PersonneDAO {

    private final String filePath = "C:\\Users\\akimt\\OneDrive\\Bureau\\DemoJava8Recap\\src\\demoLayeredArchitecture\\personne.db";


    // Read

    public Personne getById(int id){

        Personne rslt;

        Optional<String> opt = Optional.empty();

        try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            opt = br.lines()
                    .filter(line -> Integer.parseInt(line.split("-")[0]) == id)
                    .findAny();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        return OutilPersonne.stringToPersonne( opt.orElseThrow(PersonneNotFoundException::new) );

    }
}
