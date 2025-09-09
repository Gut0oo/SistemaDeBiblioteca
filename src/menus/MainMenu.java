package menus;

import java.util.Scanner;

public class MainMenu {
    private Scanner sc = new Scanner(System.in);

    public void exibir(){
        int option;
        UserMenu userMenu = new UserMenu();
        do{
            System.out.println("1 - Gerenciar Usuários");
            System.out.println("2 - Gerenciar Livros");
            System.out.println("3 - Gerenciar Empréstimos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            option = sc.nextInt();

            switch (option){
                case 1:
                    userMenu.exibir();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }
        }while(option != 0);
    }
}
