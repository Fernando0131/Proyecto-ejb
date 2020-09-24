/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Cuenta;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import servicios.CuentaFacadeLocal;

/**
 *
 * @author FERNANDO
 */
@Named("cuentabeans")
@RequestScoped
public class ejbcuenta {

    @EJB
    private CuentaFacadeLocal cuentaFacade;
    private Cuenta newcuenta;

    public Cuenta getNewcuenta() {
        if(newcuenta==null){
        
        newcuenta= new Cuenta();
        }
        return newcuenta;
    }

    public void setNewcuenta(Cuenta newcuenta) {
        this.newcuenta = newcuenta;
    }
    
    public ejbcuenta(){


}
    
    public List<Cuenta>getCuenta(){
        return this.cuentaFacade.findAll();
    
    
    }
    
    public void Insertar(){
    
    this.cuentaFacade.create(newcuenta);
    }
    
    public void Eliminar(Cuenta cuenta){
    
    this.cuentaFacade.remove(cuenta);
    }
    
    public void Actualizar(Cuenta cuenta){
    
    this.cuentaFacade.edit(cuenta);
    
    }
    
    
}