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
                    ConnectToCanada();
                    break;
            }

        } while (choice != 0);
    }

    public static void ConnectToCanada() {
        PingConfiguration pingConfiguration = new PingConfiguration("www.canada.ca", 10, 1000);

        String serverAddress = pingConfiguration.getServerAddress();
        int numberOfRequest = pingConfiguration.getRequestSendAmount();
        int timeoutMillis = pingConfiguration.getTimeoutMillis();

        PingConfiguration.ConnectToServer(serverAddress, numberOfRequest, timeoutMillis);
    }

    public static void ConnectToJapan() {
        PingConfiguration pingConfiguration = new PingConfiguration("www.evastore.jp", 10, 1000);

        String serverAddress = pingConfiguration.getServerAddress();
        int numberOfRequest = pingConfiguration.getRequestSendAmount();
        int timeoutMillis = pingConfiguration.getTimeoutMillis();

        PingConfiguration.ConnectToServer(serverAddress, numberOfRequest, timeoutMillis);
    }

    public static void DisplayMenu() {
        System.out.println("=========== Menu ===========");
        System.out.println("1.Test japan server latency");
        System.out.println("2.Test canada server latency");
        System.out.println("3.Test custom website");
        System.out.println("0.EXIT");
        System.out.println("============================");
    }
}
