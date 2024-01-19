import java.io.IOException;
import java.net.InetAddress;

public class pingTester {
    public static void main(String[] args) {
        PingConfiguration pingConfiguration = new PingConfiguration("www.evastore.jp", 100, 1000);

        String serverAddress = pingConfiguration.getServerAddress();
        int numberOfRequest = pingConfiguration.getRequestSendAmount();
        int timeoutMillis = pingConfiguration.getTimeoutMillis();

        for(int i = 0; i < numberOfRequest; i++) {
            //System.out.println("Connecting to server..."); TODO implement better 'connecting' feature;
            long startTime = System.currentTimeMillis();
            boolean isReachable = pingServer(serverAddress, timeoutMillis);
            long endTime = System.currentTimeMillis();

            if(isReachable) {
                long latency = endTime - startTime;
                System.out.println("Latency: " + latency + "ms");
            } else {
                System.out.println("Server is not reachable");
            }
            try {
                Thread.sleep(timeoutMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean pingServer(String serverAddress, int timeoutMillis) {
        try {
            return InetAddress.getByName(serverAddress).isReachable(timeoutMillis);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
