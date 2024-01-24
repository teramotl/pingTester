import java.util.Scanner;

public class pingTester {
    public static void main(String[] args) {

        int choice;
        do {

            Scanner scanner = new Scanner(System.in);
            DisplayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ConnectToJapan();
                    break;
                case 2:
                    ConnectToCustomWeb();
                    break;
                case 3:
                    CountryIPs();
                    break;
            }

        } while (choice != 0);
    }

    public static void ConnectToCustomWeb() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter domain  or ip address:");
        String customServerAddress = sc.next();

        PingConfiguration pingConfiguration = new PingConfiguration(customServerAddress, 10, 1000);
        int numberOfRequest = pingConfiguration.getRequestSendAmount();
        int timeoutMillis = pingConfiguration.getTimeoutMillis();
        PingConfiguration.ConnectToServer(customServerAddress, numberOfRequest, timeoutMillis);

    }

    public static void ConnectToJapan() {
        PingConfiguration pingConfiguration = new PingConfiguration("www.evastore.jp", 10, 1000);

        String serverAddress = pingConfiguration.getServerAddress();
        int numberOfRequest = pingConfiguration.getRequestSendAmount();
        int timeoutMillis = pingConfiguration.getTimeoutMillis();

        PingConfiguration.ConnectToServer(serverAddress, numberOfRequest, timeoutMillis);
    }
    public static void CountryIPs() {
        System.out.println("RUSSIA(MOSCOW) - 46.17.46.213" +
                "\nCANADA - www.canada.ca" +
                "\nGERMANY - www.deutschland.de" +
                "\nUZBEKISTAN - my.gov.uzD");
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
