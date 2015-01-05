
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lourivaldo
 */
public class Main {

    public static void main(String[] args) {
        BibliotecaSetorial setorialA;
        BibliotecaSetorial setorialB;
        BibliotecaCentral central;
        //        ServerCentral central = new ServerCentral("localhost", "1099", "Central");

        try {
            central = new BibliotecaCentral();
            central.setNome("Central");
            central.setHost("localhost");
            central.setPorta("1099");
            central.iniciarRMI();

            setorialA = new BibliotecaSetorial();
            setorialA.setNome("SetorialA");
            setorialA.setHost("localhost");
            setorialA.setPorta("1099");
            setorialA.iniciarRMI();
            setorialA.conectarComCentral("localhost", "1099", "Central");

            setorialB = new BibliotecaSetorial();
            setorialB.setNome("SetorialB");
            setorialB.setHost("localhost");
            setorialB.setPorta("1099");
            setorialB.iniciarRMI();
            setorialB.conectarComCentral("localhost", "1099", "Central");
            
            int matricula = 1;
            setorialA.cadastrar("Loro");
            setorialB.cadastrar("Joao");

            System.out.print("A:"+setorialA.consultarQtdLivros(matricula));
            System.out.println(" # B:"+setorialB.consultarQtdLivros(matricula));
            setorialA.emprestar(2, matricula);
            System.out.print("A:"+setorialA.consultarQtdLivros(matricula));
            System.out.println(" # B:"+setorialB.consultarQtdLivros(matricula));
            setorialB.emprestar(1, matricula);
            System.out.print("A:"+setorialA.consultarQtdLivros(matricula));
            System.out.println(" # B:"+setorialB.consultarQtdLivros(matricula));
            setorialB.emprestar(1, matricula);
            System.out.print("A:"+setorialA.consultarQtdLivros(matricula));
            System.out.println(" # B:"+setorialB.consultarQtdLivros(matricula));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
