package demoLayeredArchitecture.dao;

import demoLayeredArchitecture.dao.model.Chien;
import demoLayeredArchitecture.outil.OutilChien;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class ChienDAO {

    String filePath =  "C:\\Users\\akimt\\OneDrive\\Bureau\\DemoJava8Recap\\src\\demoLayeredArchitecture\\chien.db";

    // Create

    public void insert(Chien chien){

        String toAdd = chien.getId() + "-" + chien.getNom() +"-"+ chien.getProprioId();

        try(FileWriter pw = new FileWriter(new File(filePath), true)){
            pw.append("\n");
            pw.append(toAdd);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }

    // Read

    public List<Chien> getAll(){

        List<Chien> rslt = null;

        try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath))))
        {
            rslt = br.lines()
                    .map(OutilChien::stringToChien)
                    .collect(Collectors.toList());
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        return rslt;
    }

    // -- getById

    // Update

    // -- update

    // Delete

    public void delete(int id){

        List<String> remainingLines = null;

        try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath))))
        {
            remainingLines = br.lines()
                    .filter(line -> Integer.parseInt( line.split("-")[0] ) != id )
                    .collect(Collectors.toList());

            try(PrintWriter pw = new PrintWriter(new File(filePath))){

                for (int i = 0; i < remainingLines.size(); i++) {
                    pw.append(remainingLines.get(i));
                    if(i!=remainingLines.size()-1)
                        pw.append("\n");
                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println("file not found");
            }

        }
        catch (IOException e)
        {
            System.out.println(e);
        }



    }


}
