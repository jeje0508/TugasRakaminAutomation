package FirstProgram;

import java.util.Scanner;
public class Percabangan {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String password = prompt("Enter password :");
        String ValidPassword = "password";

        //Jika benar maka selamat datang bos
        // Jika salah (else) maka error message
        if(password.equals(ValidPassword)){
            System.out.println("Selamat datang bos!");
        } else {
            System.out.println("Password Salah, coba lagi");
        }
        System.out.println("Terimakasih sudah menggunakan aplikasi kami");
    }

    public static String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

}
