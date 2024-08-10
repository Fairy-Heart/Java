import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // app default property
        JFrame login_window= new JFrame();
        login_window.setTitle("Login"); // set title for app
        login_window.setSize(436, 645);
        login_window.setLayout(null);
        login_window.getContentPane().setBackground(new Color(33 , 33 ,33));
        //login_window.setIconImage(); set icon here.
        login_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login_window.setResizable(false);

        // set font
        Font inputFont = new Font("Arial", Font.PLAIN, 14);

        // create input username
        JTextField inputUsername = new JTextField();
        inputUsername.setBounds(30 , 50, 250, 20);
        inputUsername.setFont(inputFont);

        // set location for input username
        Point inputUsernameTop = inputUsername.getLocation();
        inputUsernameTop.y += 200;
        inputUsername.setLocation(inputUsernameTop);

        // Login button property
        JButton loginButton = new JButton();
        loginButton.setBounds(290, 20, 100, 20);
        loginButton.setBackground(new Color(33 , 33 ,33));
        loginButton.setBorder(null);
        loginButton.setForeground(Color.WHITE);
        loginButton.setText("Login");
        loginButton.setFocusPainted(false);

        // set location for  button login

        Point loginButtonTop = loginButton.getLocation();
        loginButtonTop.y += 300;
        loginButton.setLocation(loginButtonTop);

        JLabel inputUsernameDescription = new JLabel();
        inputUsernameDescription.setText("Input your username/email");
        inputUsernameDescription.setBounds(30, 50, 200, 50);
        inputUsernameDescription.setForeground(Color.WHITE);
        inputUsernameDescription.setFont(inputFont);

        Point inputUsernameDescriptionTop = inputUsernameDescription.getLocation();
        inputUsernameDescriptionTop.y += 165;
        inputUsernameDescription.setLocation(inputUsernameDescriptionTop);

        // end property for input username. Then, we will
        // create password input

        JPasswordField inputPassword = new JPasswordField();
        inputPassword.setBounds(30, 320, 250, 20);
        inputPassword.setBorder(null);

        JLabel  inputPasswordLabel = new JLabel();
        inputPasswordLabel.setBounds(30, 300, 200, 20);
        inputPasswordLabel.setFont(inputFont);
        inputPasswordLabel.setForeground(Color.WHITE);
        inputPasswordLabel.setText("Your password");

        // set property for app
        inputUsername.setFont(inputFont);
        inputUsername.setBorder(null);
        login_window.add(inputUsername);
        login_window.add(loginButton);
        login_window.add(inputUsernameDescription);
        login_window.add(inputPassword);
        login_window.add(inputPasswordLabel);
        login_window.setVisible(true);
    }
}