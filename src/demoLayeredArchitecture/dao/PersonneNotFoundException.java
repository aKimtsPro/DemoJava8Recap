package demoLayeredArchitecture.dao;

public class PersonneNotFoundException extends RuntimeException {

    public PersonneNotFoundException() {
        super("la personne n'existe pas");
    }
}
