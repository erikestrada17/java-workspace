package utilidades;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public final class Utiles {
	
	public static Random r = new Random();
	public static Scanner s = new Scanner(System.in);
	
	public static void delay(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static int ingresarEntero(int min, int max) {
        boolean error = false;
        int valor = 0;
        do {
            error = false;
            try {
                valor = s.nextInt();
                if((valor<min)||(valor>max)) {
                    error = true;
                    System.out.println("Error. Debe ingresar un numero entre " + min + " y " + max);
                }
            }catch(InputMismatchException e) {
                System.out.println("Tipo de dato mal ingresado. Vuelva a intentar");
                error = true;
                s.nextLine();
            }catch(Exception e) {
                System.out.println("Error desconocido");
                error = true;
                s.nextLine();
            }
        }while(error);
        s.nextLine();
        return valor;
    }
	
	public static float ingresarDecimal(float min, float max) {
        boolean error = false;
        float valor = 0;
        do {
            error = false;
            try {
                valor = s.nextFloat();
                if((valor<min)||(valor>max)) {
                    error = true;
                    System.out.println("Error. Debe ingresar un numero entre " + min + " y " + max);
                }
            }catch(InputMismatchException e) {
                System.out.println("Tipo de dato mal ingresado. Vuelva a intentar");
                error = true;
                s.nextLine();
            }catch(Exception e) {
                System.out.println("Error desconocido");
                error = true;
                s.nextLine();
            }
        }while(error);
        s.nextLine();
        return valor;
    }
	
	public static boolean estaEntre(int nro, int min, int max) {
		if((nro>=min)&&(nro<=max)){
			return true;
		}
		return false;
	}
	
	public static void msg() {
		System.out.println();
	}
	
	public static void msg(String mensaje) {
		System.out.println(mensaje);
	}
	
	public static void msg(int mensaje) {
		System.out.println(mensaje);
	}
	
	public static int listarElegir(Listable[] elems) {
		for (int i = 0; i < elems.length; i++) {
			System.out.println((i+1)+") " + elems[i].getNombre());
		}
		int opc = ingresarEntero(1,elems.length);
		return opc-1;
	}

}
