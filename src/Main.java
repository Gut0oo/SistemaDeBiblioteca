import DAO.UsuarioDAO;
import entity.Usuario;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Usuario u = new Usuario(10438415, "Gustavo", "Aluno", "CC");

        new UsuarioDAO().cadastrarUsuario(u);
    }
}