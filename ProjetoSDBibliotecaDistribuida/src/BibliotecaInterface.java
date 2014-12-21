
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BibliotecaInterface extends Remote {

    public Aluno consultarAluno(String matricula)
            throws RemoteException;

    public void cadastrarAluno(Aluno aluno)
            throws RemoteException;
}
