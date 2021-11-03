package ad_2_1_3_filemenu;

import java.util.Scanner;

/**
 *
 * @author Iván Zambrana Naranjo
 */
public class AD_2_1_3_FileMenu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Creamos escaner
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        
        try
        {
            //Creación del menú
            while(!exit)
            {   //Mostrar opciones
                System.out.println("\n\n\n----------------------------------------");
                System.out.println("--------------MENU FILE-----------------");
                System.out.println("----------------------------------------");
                System.out.println("1. Crear un nuevo directorio.");
                System.out.println("2. Crear un fichero vacío.");
                System.out.println("3. Listar el contenido de un fichero o directorio.");
                System.out.println("4. Renombrar un fichero o directorio.");
                System.out.println("5. Borrar un fichero o directorio.");
                System.out.println("6. Introducir una cadena de texto a un fichero existente.");
                System.out.println("7. Agregar una cadena a un fichero existente.");
                System.out.println("8. Salir");
                
                //Captura opción insertada por teclado
                System.out.println("Elija una opción: ");
                int option = sc.nextInt();
                
                //Manejo de opciones
                switch(option){
                    case 1:
                        System.out.println("---CREAR UN NUEVO DIRECTORIO---");
                    break;
                        
                    case 2:
                        System.out.println("---CREAR UN FICHERO VACÍO---");
                    break;
                        
                    case 3:
                        System.out.println("---LISTAR CONTENIDO DE FICHERO O DIRECTORIO---");
                    break;
                        
                    case 4:
                        System.out.println("---RENOMBRAR FICHERO O DIRECTORIO---");
                    break;
                        
                    case 5:
                       System.out.println("---BORRAR FICHERO O DIRECTORIO---");
                    break;
                    
                    case 6:
                        System.out.println("---INTRODUCIR TEXTO EN FICHERO EXISTENTE---");
                    break;
                    
                    case 7:
                        System.out.println("---AGREGAR CADENA A UN FICHERO EXISTENTE---");
                    break;
                    
                    case 8:
                        System.out.println("Saliendo...");
                        exit = true;
                    break;
                    
                    default:
                        System.out.println("Elija un numero entre 1 y 8.");
                }
            }   
            
            
            
        } catch (Exception e)
        {
            System.out.println("--ERROR--");
        }
    }
    
}
