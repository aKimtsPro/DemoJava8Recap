package demoLayeredArchitecture.presentation;

import demoLayeredArchitecture.business.ChienService;
import demoLayeredArchitecture.business.PersonneService;
import demoLayeredArchitecture.business.model.ChienDTO;

import java.util.Scanner;

public class InterfaceConsole {

    private PersonneService pServ = new PersonneService();
    private ChienService cServ = new ChienService();


    private void printMenu(){
        System.out.println("Menu :");
        System.out.println("1 - Créer un chien");
        System.out.println("2 - Voir les chiens");
        System.out.println("3 - Supprimer un chien");
        System.out.println("4 - Voir un propriétaire");
        System.out.println("5 - Quitter");
    }

    private String getMenuChoice()
    {
        System.out.println("Veuillez entrer une option du menu:");
        Scanner sc = new Scanner(System.in);
        String rslt = sc.nextLine();
        return rslt;
    }

    public void runInterface()
    {
        String choice = "";
        do{
            printMenu();
            choice = getMenuChoice();
            connectAction(choice);
        }while(!choice.equals("5"));
    }

    private void connectAction(String choice)
    {
        switch (choice)
        {
            case "1":
                createChien();
                break;
            case "2":
                voirChien();
                break;
            case "3":
                supprimerChien();
                break;
            case "4":
                voirProprio();
                break;
        }
    }

    private void createChien()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer l'id du chien");
        int id = scanner.nextInt();

        System.out.println("Veuillez entrer le nom du chien");
        String nom = scanner.next();

        System.out.println("Veuillez entrer l'id du propriétaire");
        int idProprio = scanner.nextInt();

        cServ.create(
                new ChienDTO(
                    id,
                    nom ,
                    pServ.getById(idProprio)
                )
        );
    }

    private void voirChien()
    {
        cServ.getAll().forEach(System.out::println);
    }

    private void supprimerChien()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer l'id du chien");
        String line = scanner.nextLine();

        int id = Integer.parseInt(line);
        cServ.delete( id );
    }

    private void voirProprio()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer l'id du proprietaire");
        int id = scanner.nextInt();

        System.out.println( pServ.getById(id) );
    }


}
