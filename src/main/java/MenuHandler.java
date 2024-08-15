import java.util.Scanner;

public class MenuHandler {
    private static Config pingConfiguration = new Config(); // Initialize with default values

    public static void handleMainMenuChoice(int choice) {
        switch (choice) {
            case 1:
                connectToCustomWeb();
                break;
            case 2:
                showCountryIPs();
                break;
            case 3:
                settingsMenu();
                break;
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    public static void handleSettingsMenuChoice(int choice) {
        switch (choice) {
            case 1:
                changeNumberOfRequests();
                break;
            case 2:
                changeConnectionTimeout();
                break;
            case 3:
                setToDefaultSettings();
                break;
            case 0:
                System.out.println("Going back...");
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    public static void showCountryIPs() {
        System.out.println("""
                RUSSIA(MOSCOW) - 46.17.46.213
                CANADA - www.canada.ca
                GERMANY - www.deutschland.de
                UZBEKISTAN - my.gov.uz""");
    }

    public static void settingsMenu() {
        System.out.println("++++++ Settings Menu +++++++");
        System.out.println("1. Change number of requests");
        System.out.println("2. Change connection timeout");
        System.out.println("3. Change to default settings");
        System.out.println("0. Go back");
        System.out.println("++++++++++++++++++++++++++++");
    }

    public static void displayMenu() {
        System.out.println("=========== Menu ===========");
        System.out.println("1. Test custom website/IP");
        System.out.println("2. Show country and website/IPs");
        System.out.println("3. Settings");
        System.out.println("0. EXIT");
        System.out.println("============================");
    }

    public static void changeNumberOfRequests() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new number of requests:");
        int newNumberOfRequests = scanner.nextInt();
        pingConfiguration.setRequestSendAmount(newNumberOfRequests);
        System.out.println("Number of requests set to: " + newNumberOfRequests);
    }

    public static void changeConnectionTimeout() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new connection timeout (in milliseconds):");
        int newTimeout = scanner.nextInt();
        pingConfiguration.setTimeoutMillis(newTimeout);
        System.out.println("Connection timeout set to: " + newTimeout + " milliseconds");
    }

    public static void setToDefaultSettings() {
        pingConfiguration.setToDefaultSettings();
        System.out.println("Settings set to default values.");
    }

    public static void connectToCustomWeb() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter domain or IP address:");
        String customServerAddress = scanner.next();
        connectTo(customServerAddress);
    }

    private static void connectTo(String serverAddress) {
        Config config = new Config(serverAddress, pingConfiguration.getRequestSendAmount(), pingConfiguration.getTimeoutMillis());
        config.connectToServer();
    }
}
