import java.io.IOException;
import java.net.InetAddress;

public class PingConfiguration {
    String serverAddress;
    private int requestSendAmount;
    private int timeoutMillis;

    public static void ConnectToServer (String serverAddress, int numberOfRequest, int timeoutMillis) {

        long totalLatency = 0;
        long minLatency = Long.MAX_VALUE;
        long maxLatency = Long.MIN_VALUE;

        for (int i = 0; i < numberOfRequest; i++) {

            //System.out.println("Connecting to server..."); TODO implement better 'connecting' feature;

            long startTime = System.currentTimeMillis();
            boolean isReachable = pingServer(serverAddress, timeoutMillis);
            long endTime = System.currentTimeMillis();

            if (isReachable) {

                long latency = endTime - startTime;
                totalLatency += latency;
                minLatency = Math.min(minLatency, latency);
                maxLatency = Math.max(maxLatency, latency);
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
        if (numberOfRequest != 0) {
            double averageLatency = (double) totalLatency / numberOfRequest;
            System.out.println("server - " + serverAddress);
            System.out.println("MIN: "+ minLatency + " AVG: " + averageLatency + " MAX: " + maxLatency);
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
