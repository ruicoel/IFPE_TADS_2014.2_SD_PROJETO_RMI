
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lourivaldo
 */
public class Main {

    public static void main(String[] args) {
        int matricula = 1;
        try {
            BibliotecaCentral central = new BibliotecaCentral();

//Setorial A
            BibliotecaSetorial setorialA = new BibliotecaSetorial();
            setorialA.setNome("setorialA");
            setorialA.setBibCentral(central);

            setorialA.cadastrarAluno("Loro", setorialA.getNome());
            System.out.println(setorialA.consultarQtdLivros(matricula));
            setorialA.emprestar(2, matricula);
//            setorialA.emprestar(1, matricula);
            System.out.println(setorialA.consultarQtdLivros(matricula));

//Setorial B
//            BibliotecaSetorial setorialB = new BibliotecaSetorial();
//            setorialB.setNome("setorialB");
//            setorialB.setBibCentral(central);
//
//            setorialB.cadastrarAluno("Joao", setorialB.getNome());
//            System.out.println(setorialB.consultarQtdLivros(matricula));
////            setorialB.emprestar(2, matricula);
//            setorialB.emprestar(1, matricula);
//            System.out.println(setorialB.consultarQtdLivros(matricula));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}