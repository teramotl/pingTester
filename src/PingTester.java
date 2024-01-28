import java.util.InputMismatchException;
import java.util.Scanner;

public class PingTester {
    private static Config pingConfiguration;

    public static void main(String[] args) {
        pingConfiguration = new Config(); // Initialize with default values

        int choice = 0;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                displayMenu();
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        connectToJapan();
                        break;
                    case 2:
                        connectToCustomWeb();
                        break;
                    case 3:
                        CountryIPs();
                        break;
                    case 4:
                        settingsMenu();
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a number to select");
            }

        } while (choice != 0);
    }

    public static void connectToCustomWeb() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter domain or IP address:");
        String customServerAddress = sc.next();
        connectTo(customServerAddress);
    }

    public static void connectToJapan() {
        connectTo("www.evastore.jp");
    }

    public static void connectTo(String serverAddress) {
        int numberOfRequests = pingConfiguration.getRequestSendAmount();
        int timeoutMillis = pingConfiguration.getTimeoutMillis();
        Config.connectToServer(serverAddress, numberOfRequests, timeoutMillis);
    }

    public static void CountryIPs() {
        System.out.println("""
                RUSSIA(MOSCOW) - 46.17.46.213
                CANADA - www.canada.ca
                GERMANY - www.deutschland.de
                UZBEKISTAN - my.gov.uz""");
    }

    public static void displayMenu() {
        System.out.println("=========== Menu ===========");
        System.out.println("1. Test Japan server latency");
        System.out.println("2. Test custom website/ip");
        System.out.println("3. Show country and website/IPs");
        System.out.println("4. Settings");
        System.out.println("0. EXIT");
        System.out.println("============================");
    }

    public static void settingsMenu() {
        System.out.println("++++++ Settings Menu +++++++");
        System.out.println("1. Change number of requests");
        System.out.println("2. Change connection timeout");
        System.out.println("3. Turn on/off connection details");
        System.out.println("4. Change to default settings");
        System.out.println("0. Go back");
        System.out.println("++++++++++++++++++++++++++++");

        handleSettingsInput();
    }

    public static void handleSettingsInput() {
        Scanner scanner = new Scanner(System.in);
        int secondChoice = scanner.nextInt();

        switch (secondChoice) {
            case 1:
                changeNumberOfRequests();
                break;
            case 2:
                changeConnectionTimeout();
                break;
            case 3:
                 //TODO implement feature later
                break;
            case 4:
                setToDefaultSettings();
                break;
            default:
                break;
        }
    }

    public static void changeNumberOfRequests() {
        System.out.println("Enter the new number of requests:");
        int newNumberOfRequests = new Scanner(System.in).nextInt();
        pingConfiguration.setRequestSendAmount(newNumberOfRequests);
        System.out.println("Number of requests set to: " + newNumberOfRequests);
    }

    public static void changeConnectionTimeout() {
        System.out.println("Enter the new connection timeout (in milliseconds):");
        int newTimeout = new Scanner(System.in).nextInt();
        pingConfiguration.setTimeoutMillis(newTimeout);
        System.out.println("Connection timeout set to: " + newTimeout + " milliseconds");
    }

    public static void setToDefaultSettings() {
        pingConfiguration.setToDefaultSettings();
        System.out.println("Settings set to default values.");
    }
}
