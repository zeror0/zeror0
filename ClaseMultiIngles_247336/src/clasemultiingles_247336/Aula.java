package clasemultiingles_247336;

/**
 *
 * @author Jesus Gonzalez 247336
 */
public class Aula {
    //private Butaca butacas [];
    Butaca butacas[];
    //Creamos arreglo de clase butaca de una longitud de 24
    public Aula(){
        this.butacas = new Butaca[24];
    }
    //Retornamos una butaca
    public Butaca getbutaca( int posicion){
        return this.butacas[posicion];
    }
    //Retornamos una alumno dependiendo de la posicion
    public int getNumButaca( String nombre){
        for (int i=0; i < this.butacas.length; i++) {
		if (this.getbutaca(i) != null) {
		  if (this.getbutaca(i).getNombre().equals(nombre)) {
			return i;
		  }
		}
	  }
      
	  return -1;
    }
    //Retornamos un alumno mediante su nombre
    public Butaca getButaca(String nombre) {
	  for (int i=0; i < this.butacas.length; i++) {
		if (this.getbutaca(i)!= null) {
		  System.out.println("## Aula.getButaca ");
		  if (this.getbutaca(i).getNombre().equals(nombre)) {
			return this.getbutaca(i);
		  }
		}
	  }
      
	  return null;
    } 
    //Establecemos un alumno a una butaca
    public void setbutaca(Butaca btca){
        int posicion = 0;
        for (int i = 0; i < this.butacas.length; i++) {
            if (this.getbutaca(i)==null) {
                //System.out.printf("## Butaca dada: %s\n", i);
                posicion = i;
                break;
            }
        }
        this.butacas[posicion]= btca;
    }
    //Busca en el arreglo un lugar disponible y lo retorna
    public int getSiguienteDisponible(){
        for (int posicion = 0; posicion < this.butacas.length; posicion++) {
            if (this.butacas[posicion]==null) {
                return posicion;
            }
        }
        return -1;
    }
    //Vuelve una butaca a null completa o elimina
    public void eliminarbutaca( int posicion){
        this.butacas[posicion]=null;
    }
    //Mostramos el mapa y colocamos una x a las butacas ocupadas
    public void mostrarOcupados(){
        //Iteradores
        int fu=8,fd=16,ft=24;
        String ocupado;
        System.out.println("X = OCUPADO");
        System.out.println("---------------------"); 
        for (int i = 0; i < 8; i++) {   
            System.out.printf("| %d ",fu);
            //Aqui lo decrementamos para buscar en el arreglo
            if (this.butacas[fu-1]!= null) {
                System.out.print("X");
            }
            //Aqui lo decrementamos en el for
            fu--;
            System.out.printf("| %d ",fd);
            if (this.butacas[fd-1]!= null) {
                System.out.print("X");
            }
            fd--;
            System.out.printf("| %d |",ft);
            if (this.butacas[ft-1]!= null) {
                System.out.print("X");
            }
            System.out.println("\n");
            ft--;
        }
        System.out.println("---------------------");
    }
    //Es igual al anterior
    public void mostrarOcupadosNivel(){
        //Iteradores
        int fu=8,fd=16,ft=24;
        String ocupado;
        System.out.println("X = OCUPADO");
        System.out.println("---------------------"); 
        for (int i = 0; i < 8; i++) {   
            System.out.printf("| %d ",fu);
            if (this.butacas[fu-1]!= null) {
                //La diferencia es que aqui imprimimos el nivel
                System.out.printf("%s",this.butacas[fu-1].getNivel());
            }
            fu--;
            System.out.printf("| %d ",fd);
            if (this.butacas[fd-1]!= null) {
                System.out.printf("%s",this.butacas[fd-1].getNivel());
            }
            fd--;
            System.out.printf("| %d |",ft);
            if (this.butacas[ft-1]!= null) {
                System.out.printf("%s",this.butacas[fu-1].getNivel());
            }
            System.out.println("\n");
            ft--;
        }
        System.out.println("---------------------");
    }
    //Se genera una lista de alumnos
    public void generarListaAlumnos(){
        System.out.println("---------------------|Lista de alumnos|------------------------");
        System.out.println("Nombre    Nivel      Edad      Sexo");
        System.out.println("--------  --------   ------    --------");
        for (int i = 0; i < butacas.length; i++) {
            System.out.printf("%s 18%s 18%d 18%s",butacas[i].getNombre(),butacas[i].getNivel(),butacas[i].getEdad(),butacas[i].getSexo());
        }
        System.out.println("---------------------------------------------------------------");
    }
    
}
