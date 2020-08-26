package demoLayeredArchitecture.dao;

import demoLayeredArchitecture.dao.model.Chien;

public class Run {

    public static void main(String[] args) {

        ChienDAO dao = new ChienDAO();
        Chien c = new Chien();
        c.setId(4);
        c.setNom("pico");
        c.setProprioId(2);

        dao.insert(c);

        dao.getAll().forEach(System.out::println);

        dao.delete(4);

        System.out.println("---------");

        dao.getAll().forEach(System.out::println);

    }
}
