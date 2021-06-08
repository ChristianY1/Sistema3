/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaschat;

import chat.frames.Chat;
import chat.frames.Chat2;
import chat.frames.Formulario;
import chat.frames.Login;
import chat.modelo.Cliente;
import chat.modelo.DetalleMensaje;
import edd.ArbolesB;
import edd.Multilista;
import edd.NodoArbol;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class SistemasChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Chat chat = new Chat();
        chat.setVisible(true);
        Chat2 chat2 = new Chat2();
        chat2.setVisible(true);
        Server servidor = new Server();*/
        /*Multilista ml = new Multilista();
        ml.leerArchivo();*/
        
        /*Login login = new Login();
        login.setVisible(true);*/
        
      /* try {
    // create a reader
    FileInputStream fis = new FileInputStream(new File("output.dat"));

    // read one byte at a time
    int ch;
    while ((ch = fis.read()) != -1) {
        System.out.print((char) ch);
    }

    // close the reader
    fis.close();

} catch (IOException ex) {
    ex.printStackTrace();
}*/
        Cliente cli1 = new Cliente("Alberto", 12, "Al12", "corr@gmail.com");
        Cliente cli2 = new Cliente("Gerardo", 32, "Ger32", "ger@gmail.com");
        Cliente cli3 = new Cliente("Alberto", 98, "Mar24", "mari24@gmail.com");
        
        ArbolesB arbol = new ArbolesB();
        NodoArbol root = new NodoArbol("a", cli1);
        NodoArbol num = new NodoArbol("ab", cli2);
        NodoArbol num2 = new NodoArbol("abc", cli3);
        arbol.inserta(num, root);
        arbol.inserta(num2, root);
        
       List<Cliente> lista =  arbol.buscarEnArbolDatosPersonales(root, "Alberto", 0, "", "");
       
        System.out.println("Nueva Lista" + lista.toString());
       
        //arbol.buscarEnArbolDatosPersonales(root, "Alberto", 0, "", "");
        
        
        /*
            public void addLibro(Libro libro){
        listaLibros.add(libro);
        System.out.println(listaLibros.toString());
    }
        */
        
        
        
        
        
        
    }
  
    
}
