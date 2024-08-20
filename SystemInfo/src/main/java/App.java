import oshi.SystemInfo;
import javax.swing.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class App extends  JFrame {
    private final Font AppFont = new Font("Arial", Font.PLAIN, 14);
    private final JLabel computerName = new JLabel();
    private final JLabel currentTime = new JLabel();
    private final JLabel osName = new JLabel();
    private final JLabel osLanguage = new JLabel();
    private final JLabel osCountry = new JLabel();

    private final  JLabel osManufacturer = new JLabel();

    private final JLabel osModel = new JLabel();

    private final JLabel osProcessor = new JLabel();

    private  final JLabel memoryRAM = new JLabel();

    private final SystemInfo systemInfo = new SystemInfo(); // this field require oshi library
    public App() {
        // App title
        this.setTitle("System Info");
        // App size
        this.setSize(760, 483);
        this.setLocationRelativeTo(null);
        // a.k.a #212121 :D
        this.getContentPane().setBackground(new Color(33 , 33 ,33));
        // Set layout to null
        this.setLayout(null);
        // Can't re-size app if set to "false"
        this.setResizable(false);
        // default close and exit
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // visible for app
        this.setVisible(true);
        // initialize UI components
        initUI();
    }
    private void initUI() {
        Font appFont = new Font("Arial", Font.PLAIN, 14);

        JLabel systemTitle = new JLabel();
        systemTitle.setText("System Information");
        systemTitle.setBounds(50, 5, 200, 60);
        systemTitle.setFont(appFont);
        systemTitle.setForeground(Color.WHITE);
        systemTitle.setVisible(true);

        // set location for  system title
        Point systemTitleLocation = systemTitle.getLocation();
        systemTitleLocation.x -= 30;
        systemTitle.setLocation(systemTitleLocation);

        this.add(systemTitle);
        currentTime();
        getComputerName();
        getOS();
        getOSLanguage();
        getOSCountry();
        getOSManufacturer();
        getSystemModel();
        getOSProcessor();
        getMemoryRAM();
    }

    private void currentTime() {

        LocalDateTime currentLocalTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss a");
        String computerDateTime = currentLocalTime.format(dateTimeFormatter);


        // Display system current date/time
        currentTime.setText(
                "<html> Current Date/Time: " +
                        "<strong>" +
                        computerDateTime +
                        "</strong> </html>"
        );
        currentTime.setFont(AppFont);
        currentTime.setForeground(Color.WHITE);
        currentTime.setBounds(190, 30, 350, 60);

        Point currentTimeLocation = currentTime.getLocation();
        currentTimeLocation.x -= 30;
        currentTime.setLocation(currentTimeLocation);

        this.add(currentTime);
    }

    private void getComputerName() {

        // Default computer name if we can't find computer name
        String computerNameValue;
        try {
            InetAddress computerAddress = InetAddress.getLocalHost();
            computerNameValue = computerAddress.getHostName();
        } catch (UnknownHostException errorWhenFindHost) {
            computerNameValue = "Unknown";
        }


        // property display for computer name

        computerName.setText(
                "<html> Computer Name: " +
                        "<strong>" +
                        computerNameValue.toUpperCase() +
                        "</strong></html>");

        computerName.setBounds(160, 50, 350, 60);
        computerName.setFont(AppFont);
        computerName.setForeground(Color.WHITE);

        // location for JLabel
        Point computerNameLocation = computerName.getLocation();
        computerNameLocation.y += 10;
        computerName.setLocation(computerNameLocation);



        this.add(computerName);
    }

    private void getOS() {
        // get operating system
        // and set property for this
        osName.setText(
                "<html>Operating System: " +
                        "<strong>" +
                        System.getProperty("os.name").toUpperCase() + "\n" +
                        System.getProperty("os.version").toUpperCase() + "\n" +
                        System.getProperty("os.arch").toUpperCase()  + "\n" +
                        "</strong> </html>"
        );
        osName.setBounds(160, 90, 300, 60);
        osName.setFont(AppFont);
        osName.setForeground(Color.WHITE);

        this.add(osName);
    }

    /*
    this function get operating system language

    */
    private void getOSLanguage() {
        // get operating system language
        osLanguage.setText(
                "<html> Operating System Language: " +
                        "<strong>" +
                        System.getProperty("user.language").toUpperCase() + "\n" +
                "</strong> </html>"
        );
        osLanguage.setFont(AppFont);
        osLanguage.setForeground(Color.WHITE);
        osLanguage.setBounds(160, 120, 250, 60);

        this.add(osLanguage);
    }

    /*
    this function get operating system country
    */
    private void getOSCountry() {
        // Get operating system country
        osCountry.setText(
                "<html> Operating System Country: " +
                        "<strong>" +
                        System.getProperty("user.country") +
                        "</strong> </html>"
        );
        osCountry.setBounds(160, 150, 200, 60);
        osCountry.setFont(AppFont);
        osCountry.setForeground(Color.WHITE);

        this.add(osCountry);
    }

    private void getOSManufacturer() {
        osManufacturer.setText(
                "<html> System Manufacturer: " +
                        "<strong>" +
                        systemInfo.getHardware()
                                .getComputerSystem().
                                getManufacturer().
                                toUpperCase() +
                        "<strong></html>"
        );
        osManufacturer.setBounds(160, 180, 250, 60);
        osManufacturer.setForeground(Color.WHITE);
        osManufacturer.setFont(AppFont);

        this.add(osManufacturer);
    }

    /*
    this function get system model
     */

    private  void getSystemModel() {
        // Property for display os model

        osModel.setText(
                "<html> System Model: " +
                        "<strong>" +
                        systemInfo.getHardware()
                                .getComputerSystem()
                                .getModel() +
                "</strong>"
        );
        osModel.setFont(AppFont);
        osModel.setBounds(160, 210, 250, 60);
        osModel.setForeground(Color.WHITE);
        this.add(osModel);
    }

    /*
    this function get operating system processor
     */
    private void getOSProcessor() {
        // Property for display operating system processor
        osProcessor.setText(
                "<html> System Processor: " +
                        "<strong>" +
                        systemInfo
                                .getHardware()
                                .getProcessor()
                                .getProcessorIdentifier()
                                .getName()
                        +
                        "</strong> <html>"
        );
        osProcessor.setBounds(160, 240, 500, 60);
        osProcessor.setFont(AppFont);
        osProcessor.setForeground(Color.WHITE);
        this.add(osProcessor);
    }

    private void getMemoryRAM() {
        String memory = systemInfo.getHardware()
                .getMemory()
                .toString()
                .replaceAll("Available", "")
                .replaceAll("GiB", "GB");

        memoryRAM.setText(
                "<htmL> Memory RAM: " +
                        "<strong>" +
                        memory +
                "</strong></html>"
        );
        memoryRAM.setFont(AppFont);
        memoryRAM.setForeground(Color.WHITE);
        memoryRAM.setBounds(160, 270, 300, 60);
        this.add(memoryRAM);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }
}
