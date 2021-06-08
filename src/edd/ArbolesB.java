/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

import chat.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauro
 */
public class ArbolesB {
      private NodoArbol r=null;

    /**
     * @return the r
     */
    public NodoArbol getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(NodoArbol r)
    {
        this.r = r;
    }
    
    public NodoArbol inserta(NodoArbol nvo, NodoArbol r)
    {
        if(r == null)
        {
            return nvo;
        }else
        {
            if (nvo.getEt().compareTo(r.getEt())<0)
            {
                r.setIzq(inserta(nvo, r.getIzq()));
            } else
            {
                r.setDer(inserta(nvo, r.getDer()));
            }
            return r;        
        }
    }
    
    public void recorridoEnOrden(NodoArbol r)
    {
        if(r!= null)
        {
            recorridoEnOrden(r.getIzq());
            System.out.print(r.getEt()+" ");
            recorridoEnOrden(r.getDer());
        }
    }
    public void recorridoPreOrden(NodoArbol r)
    {
        if(r!= null)
        {
            System.out.print(r.getEt()+" ");
            recorridoPreOrden(r.getIzq());
            recorridoPreOrden(r.getDer());
        }
    }
    public void recorridoPosOrden(NodoArbol r)
    {
        if(r!= null)
        {
            recorridoPosOrden(r.getIzq());
            recorridoPosOrden(r.getDer());
            System.out.print(r.getEt()+" ");
        }
    }
    
    public NodoArbol [] elimina(String et, NodoArbol r)
    {
        NodoArbol arr[] = new NodoArbol[2];
        if (r== null)
        {
            arr[0]=null; //dato eliminado en la posicion cero
            arr[1]=r; //la nueva r en la posicion uno
        } else
        {
            if (r.getEt().equals(et))
            {
                arr[0]=r; //encontre el dato a eliminar
                if (r.getIzq()==null && r.getDer()==null)
                {
                    //cuando no tiene hijos
                    arr[1]=null;
                } else
                {
                    if (!(r.getDer() != null && r.getIzq() != null))
                    {
                        //cuando tiene un hijo
                        if (r.getIzq() != null)
                        {
                            arr[1]=r.getIzq();
                            r.setIzq(null);
                        } else
                        {
                            arr[1]=r.getDer();
                            r.setDer(null);
                        }
                    } else
                    {
                        //cuando tiene dos hijos
                        NodoArbol se ;
                        if (r.getDer().getIzq() == null)
                        {
                            se=r.getDer();
                            se.setIzq(r.getIzq());
                        } else
                        {
                            NodoArbol pse =sucesor(r.getDer());
                            se = pse.getIzq();
                            pse.setIzq(se.getDer());
                            se.setDer(r.getDer());
                            se.setIzq(r.getIzq());
                        }
                        arr[1]=se;
                        r.setDer(null);
                        r.setIzq(null);
                    }
                }
            } else
            {
                //buscar el elemento a borrar
                if (r.getEt().compareTo(et)>0)
                {
                    arr=elimina(et, r.getIzq());
                    r.setIzq(arr[1]);
                } else
                {
                     arr=elimina(et, r.getDer());
                     r.setDer(arr[1]);
                }
                arr[1]=r;
            }
        }
        return arr;
    }
    
    public NodoArbol sucesor(NodoArbol aux)
    {
        if (aux.getIzq().getIzq() == null)
        {
            return aux;
        } else
        {
            return sucesor(aux.getIzq());
        }
    }
    public void agrgearCliente(List<Cliente> Listacliente){
        for (int i = 0; i < Listacliente.size() ; i++) {
            Listacliente.add(Listacliente.get(i));  
            System.out.println("informacion" + Listacliente.get(i).getNombre());
        }
        
    }
            
     public List<Cliente> buscarEnArbolDatosPersonales( NodoArbol r ,String nombre, int edad, String usuario, String email){
         List<Cliente> listaClientes = new ArrayList<>();
         Cliente hijo = null;
         Cliente cliente = new Cliente();
        
         
          if(r!= null)
        {
    
            buscarEnArbolDatosPersonales(r.getIzq(),nombre,edad, email, usuario);
            
            //System.out.print(r.getEt()+" ");
            if (nombre != "") {
                if (r.getObj().getNombre() == nombre) {
                    hijo = new Cliente();
                    hijo.setNombre(r.getObj().getNombre());
                    //cliente  = r.getObj();                    
                    listaClientes.add(hijo);
                    
                    System.out.println("Este es el string del objketo ---->" + listaClientes.toString());
//agrgearCliente(listaClientes);
                    //System.out.println(r.getObj());
                    //System.out.println("lista" + listaClientes.get(0));
                    
                
            }

            }
            if (edad != 0) {
                if (r.getObj().getEdad() == edad) {
                 System.out.println(r.getObj());
                 
                
            }
                
            }
            if (email != "") {
                if (r.getObj().getCorreo() == email) {
                 System.out.println(r.getObj());
          
            }
                
            }
            if (usuario != "") {
                 if (r.getObj().getUsuario() == usuario) {
                 System.out.println(r.getObj());
          
            }
                
            }
          
            buscarEnArbolDatosPersonales(r.getDer(),nombre,edad, email, usuario);
        }
          return listaClientes;
        
        
    }

    void inserta(NodoArbol root, Nodo r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
