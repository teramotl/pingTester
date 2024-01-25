import java.util.InputMismatchException;
import java.util.Scanner;

public class pingTester {
    public static void main(String[] args) {

        int choice = 0;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                DisplayMenu();
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
                }

            } catch (InputMismatchException e) {
                System.out.println("please enter number to select");
                ;
            }

        } while (choice != 0);
    }

    public static void connectToCustomWeb() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter domain  or ip address:");
        String customServerAddress = sc.next();
        connectTo(customServerAddress);
    }

    public static void connectToJapan() {
        connectTo("www.evastore.jp");
    }

    public static void connectTo(String serverAddress) {
        PingConfiguration pingConfiguration = new PingConfiguration(serverAddress, 10, 1000);
        int numberOfRequests = pingConfiguration.getRequestSendAmount();
        int timeoutMillis = pingConfiguration.getTimeoutMillis();
        PingConfiguration.ConnectToServer(serverAddress, numberOfRequests, timeoutMillis);
    }

    public static void CountryIPs() {
        System.out.println("RUSSIA(MOSCOW) - 46.17.46.213" +
                "\nCANADA - www.canada.ca" +
                "\nGERMANY - www.deutschland.de" +
                "\nUZBEKISTAN - my.gov.uz");
    }

    public static void DisplayMenu() {
        System.out.println("=========== Menu ===========");
        System.out.println("1.Test japan server latency");
        System.out.println("2.Test custom website/ip");
        System.out.println("3.Show country and website/IPs");
        System.out.println("0.EXIT");
        System.out.println("============================");
    }
}
