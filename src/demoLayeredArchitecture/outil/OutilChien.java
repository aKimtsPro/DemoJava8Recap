package demoLayeredArchitecture.outil;

import demoLayeredArchitecture.dao.model.Chien;

public class OutilChien {

    public static Chien stringToChien(String chaine){

        String[] tab = chaine.split("-");
        Chien rslt = new Chien();

        try{
            rslt.setId(Integer.parseInt(tab[0]));
            rslt.setNom(tab[1]);
            rslt.setProprioId(Integer.parseInt(tab[2]));

        }
        catch(Exception e)
        {
            System.out.println("format incorrect");
        }

        return rslt;

    }

    public static String chienToString(Chien chien){
        return chien.getId() + "-" + chien.getNom() +"-"+ chien.getProprioId();
    }


}
