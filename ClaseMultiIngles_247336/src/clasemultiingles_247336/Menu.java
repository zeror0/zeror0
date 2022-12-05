package clasemultiingles_247336;
import java.util.Scanner;
/**
 *
 * @author Jesus Gonzalez 247336
 */
public class Menu {
    private Aula insti;
    Scanner tec = new Scanner(System.in);
    int opc;
    
    //Crea objeto tipo aula
    public Menu(){
       this.insti = new Aula();
    }
    //Mostramos el menu y ejecutamos su logica
    public void desplegarMenu(){
        while (opc<7) {            
            System.out.println("1. Registrar Alumno.");
            System.out.println("2. Eliminar Alumno.");
            System.out.println("3. Mostrar información del Alumno.");
            System.out.println("4. Editar Alumno.");
            System.out.println("5. Mostrar mapa de aula.");
            System.out.println("6. Lista de Alumnos.");
            System.out.println("7. Salir.\n\n");
            System.out.println("Teclee opcion:");
            opc = tec.nextInt();
            switch (opc) {
                case 1:this.registrarAlumno();
                    break;
                case 2:this.eliminarAlumno();  
                    break;
                case 3:this.mostrarOcupacionIndividual();
                    break;
                case 4:this.editarAlumno();
                    break;
                case 5:this.mostrarMapaOcupacion();
                    break;
                case 6:this.generarListaAlumnos();
                    break;
                case 7: 
                    System.out.println("Cerrando...");
                    opc = opc+1;
                    break;
                default:
                    System.out.println("Opcion no existente, cerrando...");
            }
        }
       
    }
    //Hacewmos logica del aula e ingresamos los datos del alumno
    private void registrarAlumno(){    
        String nombre,sex,niv,opc;
        int edad, btcaDisp;
        while (this.insti.getSiguienteDisponible()!= -1 ) {            
            if (this.insti.getSiguienteDisponible()>-1) {
                System.out.println("Inserta nombre del alumno:");
                nombre = tec.next();
                System.out.println("Inserta su edad:");
                edad = tec.nextInt();
                System.out.println("Inserta su sexo:");
                sex = tec.next();
                System.out.println("Inserta su nivel de ingles");
                niv = tec.next();
                btcaDisp = this.insti.getSiguienteDisponible();
                    if (btcaDisp >= 0) {
                        System.out.println("-------------------|CONFIRMACION|------------------");
                        System.out.printf("Nombre: %s\n", nombre);
                        System.out.printf("Nivel: %s\n", niv);
                        System.out.printf("Edad: %d\n", edad);
                        System.out.printf("Sexo: %s\n", sex);
                        System.out.printf("Butaca asignada: %d\n", btcaDisp + 1);
                        //Confirmamos
                        System.out.println("\n\tConfirmar el registro? (S/N): ");
                        opc = tec.next();
                    //Verificamos varias posibles entradas de S
                    if (opc.equals("S")||opc.equals("s")||opc.equals("SI")||opc.equals("si")) {
                        Butaca butaca = new Butaca(nombre, niv, sex, edad);
                        this.insti.setbutaca(butaca);
                    System.out.println("[*] Alumno registrado con exito!\n");
                    }else{
                        System.out.println("Operacion concelada");
                        btcaDisp=-10;
                    }                     
                    }else{
                        System.out.println("No se pudo encontrar butaca para el alumno");
                    }
            }
            System.out.println("¿Desea continuar con otro Alumno (s/n)?");
                opc = tec.next();
                if (opc.equals("n")||opc.equals("N")||opc.equals("NO")||opc.equals("no")) {
                    System.out.println("----------------------------------------------");
                  break;  
                }
        }
    }
    //Hacemos prints y logica de eliminar alumno
    private void eliminarAlumno(){
        int posicion,opc=0;
        Butaca btcaOcu;
        //Mostramos mapa
        this.mostrarMapaOcupacion();
        //buscamos por posicion
        while (opc==0) {            
            System.out.println("Ingrese el numero de butaca a liberar:");
            posicion= tec.nextInt();
        
            btcaOcu = this.insti.getbutaca(posicion-1);
            //Mostramos informacion
            System.out.println("-------------------|CONFIRMACION|------------------");
            System.out.printf("Nombre: %s\n",btcaOcu.getNombre());
            System.out.printf("Nivel: %s\n",btcaOcu.getNivel());
            System.out.printf("Edad: %d\n",btcaOcu.getEdad());
            System.out.printf("Sexo: %s\n",btcaOcu.getSexo());
            System.out.println("Mensualidad:");
            System.out.printf("Butaca asignada: %d\n",posicion);
            //Confrimamos
            System.out.println("¿Confirmar que desea desocupar la butaca? 1.- SI | 2.- NO");
            opc= tec.nextInt();
            if (opc ==1) {
                this.insti.eliminarbutaca(posicion-1);
                System.out.println("Eliminando...");
                System.out.println("Alumno Eliminado");    
                
            }
        }
        
    }
    //En este se mostrara los datos de manera individual de un alumno, llamandolo por su nombre
    private void mostrarOcupacionIndividual(){
        Butaca btcaOcu;
        String nombre,opc="s";
        while (opc=="s"||opc=="S"||opc=="si"||opc=="SI") {            
            System.out.println("Ingrese el nombre del alumno:");
            nombre = tec.next();
            
            for (int i = 0; i < this.insti.butacas.length; i++) {
                if (this.insti.butacas[i].getNombre().equals(nombre)) {
                    //btcaOcu = this.insti.getbutaca(i);
                    //Enviamos la confirmacion de info
                    System.out.println("-------------------|CONFIRMACION|------------------");
                    System.out.printf("Nombre: %s\n",insti.butacas[i].getNombre());
                    System.out.printf("Nivel: %s\n",insti.butacas[i].getNivel());
                    System.out.printf("Edad: %d\n",insti.butacas[i].getEdad());
                    System.out.printf("Sexo: %s\n",insti.butacas[i].getSexo());
                    System.out.println("Mensualidad:");
                    System.out.printf("Butaca asignada: %d\n",i+1); 
                
                }else{
                    //si no hay un nombre o alumno llamado asi en el arreglo
                    System.out.println("El Alumno proporcionado no está registrado.");
                }
            }
            System.out.println("¿Desea verificar la información de otro alumno? (S/N)");
            opc = tec.next();
            
        }
    }
    //Editamos la informacion de un alumno ya registrado
    private void editarAlumno(){
        String nombre,sex,niv;
        int edad,opc;
        Butaca editar = new Butaca();
        System.out.println("Ingrese el nombre del alumno a editar:");
        nombre = tec.next();
            for (int i = 0; i < this.insti.butacas.length; i++) {
                if (this.insti.butacas[i].getNombre().equals(nombre)) {
                    this.insti.butacas[i] = editar;
                    //Con el nombre buscando en el arreglo, mostramos la info a cambiar
                    System.out.println("-------------------|EDICION|------------------");
                    System.out.printf("Nombre: %s\n",insti.butacas[i].getNombre());
                    System.out.printf("Nivel: %s\n",insti.butacas[i].getNivel());
                    System.out.printf("Edad: %d\n",insti.butacas[i].getEdad());
                    System.out.printf("Sexo: %s\n",insti.butacas[i].getSexo());
                    System.out.println("Mensualidad:");
                    System.out.printf("Butaca asignada: %d\n",i+1);
                    //Confirmamos
                    System.out.println("Desea editar a este alumno? 1-Si, 2-No");
                    opc = tec.nextInt();
                    if (opc==1) {
                        //Cambiamos
                        System.out.println("Inserta nombre del alumno:");
                        nombre = tec.next();
                        System.out.println("Inserta su edad:");
                        edad = tec.nextInt();
                        System.out.println("Inserta su sexo:");
                        sex = tec.next();
                        System.out.println("Inserta su nivel de ingles");
                        niv = tec.next();
                        //Hacemos el set
                        editar = this.insti.butacas[i];
                        editar.setEdad(edad);
                        editar.setNivel(niv);
                        editar.setNombre(nombre);
                        editar.setSexo(sex);
                        System.out.println("****Alumno editado*****");
                    }else {
                        System.out.println("Regresando al menu...");
                        opc=2;
                    }
                
                }else{
                    System.out.println("El Alumno proporcionado no está registrado.");
                }
            }
    }
    //Mostramos mapa
    private void mostrarMapaOcupacion(){
        this.insti.mostrarOcupados();  
    }
    //Generamos lista
    private void generarListaAlumnos(){
        this.insti.generarListaAlumnos();
    }
}
