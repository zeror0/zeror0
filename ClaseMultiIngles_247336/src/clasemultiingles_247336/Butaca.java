package clasemultiingles_247336;

/**
 *
 * @author Jesus Gonzalez 247336
 */
public class Butaca {
    private String nombre,niv,sex;
    private int edad;
    
    public Butaca(){
        this.nombre = "";
        this.niv = "";
        this.sex = "";
        this.edad = 0;
    }
    public Butaca(String nombre, String niv,String sex, int edad){
        this.nombre = nombre;
        this.niv = niv;
        this.sex = sex;
        this.edad = edad;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNivel(){
        return niv;
    }
    public void setNivel(String niv){
        this.niv = niv;
    }
    public String getSexo(){
        return sex;
    }
    public void setSexo(String sex){
        this.sex = sex;
    }
    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    
}
