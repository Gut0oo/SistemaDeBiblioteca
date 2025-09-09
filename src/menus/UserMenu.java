package menus;

import entity.usuario.Student;
import entity.usuario.Teacher;
import entity.usuario.User;

import DAO.UserDAO;

import java.util.Scanner;

public class UserMenu {
    private UserDAO dao = new UserDAO();
    private Scanner sc = new Scanner(System.in);

    public void exibir(){
        int option;

        do{
            System.out.println("1 - Cadastrar Usuário (Aluno / Professor)");
            System.out.println("2 - Listar Usuários");
            System.out.println("3 - Buscar Usuário por ID");
            System.out.println("4 - Atualizar Usuário");
            System.out.println("5 - Remover Usuário");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            option = sc.nextInt();

            switch (option){
                case 1:
                    cadastro();
                    break;
                case 2:

                    break;
                case 3:
                    consulta();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }
        }while(option != 0);
    }

    public void cadastro(){

        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Curso: ");
        String course = sc.nextLine();
        System.out.print("Tipo (a - ALUNO || p - PROFESSOR): ");
        String type = String.valueOf(sc.next().charAt(0)).toLowerCase();

        if(!type.equals("a") && !type.equals("p")){
            System.out.println("Invalido");
        }else{
            User user;

            if(type.equals("a")){
                user = new Student(id, nome, course);
            }else{
                user = new Teacher(id, nome, course);
            }

            dao.cadastrarUsuario(user);
        }
    }

    public void consulta(){
        System.out.print("ID: ");
        int id = sc.nextInt();

        dao.consultarUsuario(id);
    }
}
