import Exceptions.SoloNumerosException;
import model.CurrencyDto;
import service.ExchangeRateService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner read = new Scanner(System.in);
    private static ExchangeRateService service = new ExchangeRateService();

    public static void main(String[] args) {
        menu();
    }



    public static int optionShow()throws SoloNumerosException {
        try{
            System.out.println("************************************************" +
                    "\n Sea bienvenido/a al conversor de monedas :) \n" +
                    "\n Escoja Opción: " +
                    "\n 1. Dolar =>> Pesos Argentinos" +
                    "\n 2. Pesos Argentinos =>> Dolares " +
                    "\n 3. Dolar =>> Real brasileño " +
                    "\n 4. Real brasileño =>> Dolar" +
                    "\n 5. Dolar =>> Peso colombiano " +
                    "\n 6. Peso colombiano =>> Dolar " +
                    "\n 7. Salir del Programa"+
                    "\n Elija una opcion valida: " +
                    "\n ************************************************");
            return read.nextInt();
        } catch (InputMismatchException e) {
             ;throw new SoloNumerosException("Entrada invalida, solos se admiten numeros");
        }
    }
    public static void showResult(double cantidad,String nombreMonedaAcambiar,String nombreDeMonedaCambio){
        CurrencyDto response = service.getTasas(nombreMonedaAcambiar);
        double totalCambio = cantidad * response.conversion_rates().get(nombreDeMonedaCambio);
        System.out.println("El valor "+cantidad+" ["+nombreMonedaAcambiar+"] corresponde al valor final =>> "+totalCambio+" ["+nombreDeMonedaCambio+"]");
    }

    public static void eleccionDeOpciones(int opcion){
        System.out.println("Ingrese una cantidad para convertir: ");
        double cantidad = read.nextDouble();

        switch (opcion){
            case 1 -> showResult(cantidad,"USD","ARS");
            case 2 -> showResult(cantidad, "ARS","USD");
            case 3 -> showResult(cantidad, "USD", "BRL");
            case 4 -> showResult(cantidad, "BRL", "USD");
            case 5 -> showResult(cantidad, "USD","COP");
            case 6 -> showResult(cantidad, "COP","USD");
        }


    }

    public static void menu(){
        try {
            int option = optionShow();
            if(option != 7){
                while (option < 7 && option >0){
                    eleccionDeOpciones(option);
                    option = optionShow();
                }
                System.out.println("opcion incorrecta, intentelo de nuevo");
                menu();
            }else
                System.out.println("fin del programa");
        } catch (SoloNumerosException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}