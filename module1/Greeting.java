import java.util.Scanner; 
 
public class Greeting { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.print("What is your name? "); 
        String name = scanner.nextLine(); 
        System.out.println("Hello, " + name + "! Your in the right place for Computer Sceince BootCamp"); 
        scanner.close(); 
    } 
}
