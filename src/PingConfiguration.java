import java.io.IOException;
import java.net.InetAddress;

public class PingConfiguration {
    String serverAddress;
    private int requestSendAmount;
    private int timeoutMillis;
    public static void ConnectToServer (String serverAddress, int numberOfRequest, int timeoutMillis) {
        for (int i = 0; i < numberOfRequest; i++) {
            //System.out.println("Connecting to server..."); TODO implement better 'connecting' feature;
            long startTime = System.currentTimeMillis();
            boolean isReachable = pingServer(serverAddress, timeoutMillis);
            long endTime = System.currentTimeMillis();

            if (isReachable) {
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

    public PingConfiguration(String serverAddress, int requestSendAmount, int timeoutMillis) {
        this.serverAddress = serverAddress;
        this.requestSendAmount = requestSendAmount;
        this.timeoutMillis = timeoutMillis;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public int getRequestSendAmount() {
        return requestSendAmount;
    }

    public void setRequestSendAmount(int requestSendAmount) {
        this.requestSendAmount = requestSendAmount;
    }

    public int getTimeoutMillis() {
        return timeoutMillis;
    }

    public void setTimeoutMillis(int timeoutMillis) {
        this.timeoutMillis = timeoutMillis;
    }
}
