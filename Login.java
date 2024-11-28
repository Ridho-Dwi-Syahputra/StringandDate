import java.util.Random;
import java.util.Scanner;

public class Login {
    private static final String USERNAME = "ridho";
    private static final String PASSWORD = "09122004";
    private static final Random random = new Random();

    public boolean logIn(Scanner scanner) {
        String captcha = generateCaptcha();
        System.out.print("Username: ");
        String inputUsername = scanner.nextLine().trim();

        System.out.print("Password: ");
        String inputPassword = scanner.nextLine().trim();

        System.out.println("Captcha: " + captcha);
        System.out.print("Masukkan Captcha: ");
        String inputCaptcha = scanner.nextLine().trim();

        if (inputUsername.equalsIgnoreCase(USERNAME) &&
            inputPassword.equals(PASSWORD) &&
            inputCaptcha.equalsIgnoreCase(captcha)) {
            System.out.println("Login berhasil.\n");
            return true;
        } else {
            System.out.println("Login gagal. Silakan coba lagi.\n");
            return false;
        }
    }

    private String generateCaptcha() {
        StringBuilder captcha = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            captcha.append(characters.charAt(index));
        }
        return captcha.toString();
    }
}
