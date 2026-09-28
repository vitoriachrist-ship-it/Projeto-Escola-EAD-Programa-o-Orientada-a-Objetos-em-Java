import java.util.Scanner;

public class Teclado {
    private static Scanner scanner = new Scanner(System.in);
    
    public static int leInt(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextInt();
    }
    
    public static double leDouble(String mensagem){
        System.out.print(mensagem);
        return scanner.nextDouble();
    }
    
    public static String leString(String mensagem){
        System.out.print(mensagem);
        return scanner.next();
    }
    
    public static char leChar(String mensagem){
        System.out.print(mensagem);
        return scanner.next().charAt(0);   
    }
}