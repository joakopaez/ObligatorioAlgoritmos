/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;
import sistema.Modalidad;

/**
 *
 * @author Usuario
 */
public class Despliegue {
    private String id;
    private String codigo;
    private boolean cuantizado;
    private Modalidad modalidad;
    private String descripcion;

    public Despliegue(String id, String codigo, boolean cuantizado, Modalidad modalidad, String descripcion) {
        this.id = id;
        this.codigo = codigo;
        this.cuantizado = cuantizado;
        this.modalidad = modalidad;
        this.descripcion = descripcion;
    }
    

    public String getId()
    {return id;}
    
    public String getCodigo()
    {return codigo;}
    
    public String getDescripcion()
    {return descripcion;}
    
    public boolean getCuantizado()
    {return cuantizado;}
    
    public Modalidad getModalidad()
    {return modalidad;}
}
