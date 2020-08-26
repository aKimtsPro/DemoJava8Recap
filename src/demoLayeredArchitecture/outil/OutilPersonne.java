package demoLayeredArchitecture.outil;

import demoLayeredArchitecture.dao.model.Personne;

public class OutilPersonne {

    public static Personne stringToPersonne(String chaine){
        String[] tab = chaine.split("-");
        Personne rslt = new Personne();

        try{
            rslt.setId(Integer.parseInt(tab[0]));
            rslt.setNom(tab[1]);
        }
        catch(Exception e)
        {
            System.out.println("format incorrect");
            return null;
        }

        return rslt;
    }

}
