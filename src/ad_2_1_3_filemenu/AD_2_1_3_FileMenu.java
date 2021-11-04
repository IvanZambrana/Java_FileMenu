package ad_2_1_3_filemenu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Iván Zambrana Naranjo
 */
public class AD_2_1_3_FileMenu {

    
    public static void main(String[] args) {
        
        //Creamos escaner
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        File archivo;
        String ruta;
        String[] paths;
        BufferedReader bf;
        String bfRead;
        String temp = "";
        String texto;
        
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
                        System.out.println("Inserte ruta del directorio a crear: ");
                        ruta = sc.next();
                        
                        //Objeto tipo File
                        archivo = new File(ruta);
                        
                        //Comprobamos que no exista
                       if(!archivo.exists())
                        {
                            //Creación del directorio
                            if(archivo.mkdirs())
                                System.out.println("Directorio creado con exito.");
                            else
                                System.out.println("Directorio no creado.");
                        }
                        else
                        {
                            System.out.println("-ERROR- El directorio ya existe");
                        }
                        
                    break;
                        
                    case 2:
                        System.out.println("---CREAR UN FICHERO VACÍO---");
                        System.out.println("Inserte ruta del directorio a crear: ");
                        ruta = sc.next();
                        
                        //Objeto tipo File
                        archivo = new File(ruta);
                        //Comprobamos que no exista
                        if(!archivo.exists())
                        {
                            if(archivo.createNewFile())
                                System.out.println("Fichero creado con exito");
                            else
                                System.out.println("Fichero no creado");
                        }
                        else
                        {
                            System.out.println("-ERROR- El fichero ya existe.");
                        }
                    break;
                        
                    case 3:
                        System.out.println("---LISTAR CONTENIDO DE FICHERO O DIRECTORIO---");
                        System.out.println("Inserte ruta de un directorio(existente): ");
                        ruta = sc.next();
                        //Objeto tipo File
                        archivo = new File(ruta);
        
                        //Comprobamos que exista
                        if (archivo.exists()) {
                            //Comprobamos que sea un directorio
                            System.out.println("Listado de " + archivo);
                            System.out.println("=============================");
                            //Comprobamos que sea un directorio
                            if (archivo.isDirectory())
                            {
                                paths = archivo.list();
                                
                                for(String path:paths) {
                                    File elemento = new File(archivo, path);
                                    System.out.println(path); 
                                }

                            }
                            else
                            {
                                bf = new BufferedReader(new FileReader(archivo));
                                while((bfRead = bf.readLine()) != null)
                                {
                                    temp += bfRead;
                                }
                                texto = temp;
                                System.out.println(texto);
                            }
                        } else
                        {
                            System.out.println("-ERROR- La ruta introducida no existe.");
                            System.out.println("Sugerencia: Si estas en Windows, un ejemplo de ruta puede ser: 'C:\\\\Program Files'");
                        }
                    break;
                        
                    case 4:
                        System.out.println("---RENOMBRAR FICHERO O DIRECTORIO---");
                        System.out.println("Inserte ruta del fichero o directorio que quiere renombrar: ");
                        ruta = sc.next();
                        //Objeto tipo File
                        archivo = new File(ruta);
        
                        //Comprobamos que exista
                        if(archivo.exists())
                        {
                            //Pedimos nuevo nombre
                            System.out.println("Inserte ruta donde quiere guardar su archivo con su nuevo nombre: ");
                            String nuevoNombre = sc.next();
                            File renFile = new File(nuevoNombre);
                            if(archivo.renameTo(renFile))
                            {
                                System.out.println("Renombrado con éxito");
                            }
                        }
                        else
                        {
                            System.out.println("-ERROR- El fichero o directorio especificado no existe.");
                        }
                    break;
                        
                    case 5:
                       System.out.println("---BORRAR FICHERO O DIRECTORIO---");
                       System.out.println("Inserte ruta del fichero o directorio que desea eliminar: ");
                       ruta = sc.next();
                       archivo = new File(ruta);
                       boolean salir = false;
                       if(archivo.exists())
                       {
                           while(!salir)
                           {
                                System.out.println("-ATENCIÓN- Se procederá a la eliminación de " + ruta + "\n¿Quiere continuar?(si, no):");
                                String confirma = sc.next();
                                if(confirma.equalsIgnoreCase("si"))
                                {
                                    if(archivo.delete())
                                        System.out.println("Archivo eliminado con exito.");
                                    else
                                        System.out.println("El archivo no se eliminó.");
                                    salir = true;
                                }
                                else if(confirma.equalsIgnoreCase("no"))
                                {
                                    System.out.println("No se eliminará el archivo.");
                                    salir = true;
                                }
                                else
                                {
                                    System.out.println("Por favor, simplemente escriba 'si' o 'no'.\n\n");
                                }
                            }
                       }
                       else
                           System.out.println("-ERROR- El fichero o directorio no existe.");
                       
                    break;
                    
                    case 6:
                        System.out.println("---INTRODUCIR TEXTO EN FICHERO EXISTENTE---");
                    break;
                    
                    case 7:
                        System.out.println("---AGREGAR CADENA A UN FICHERO EXISTENTE---");
                        //Acabar
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
