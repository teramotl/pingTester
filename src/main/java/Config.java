import java.io.IOException;
import java.net.InetAddress;

public class Config {
    private String serverAddress;
    private int requestSendAmount = 10;
    private int timeoutMillis = 1000;

    public Config() {
        // Default constructor
    }

    public Config(String serverAddress, int requestSendAmount, int timeoutMillis) {
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

    public void setToDefaultSettings() {
        this.requestSendAmount = 10;
        this.timeoutMillis = 1000;
    }

    public void connectToServer() {
        connectToServer(this.serverAddress, this.requestSendAmount, this.timeoutMillis);
    }

    private static void connectToServer(String serverAddress, int numberOfRequests, int timeoutMillis) {
        long totalLatency = 0;
        long minLatency = Long.MAX_VALUE;
        long maxLatency = Long.MIN_VALUE;

        for (int i = 0; i < numberOfRequests; i++) {
            long startTime = System.currentTimeMillis();
            boolean isReachable = pingServer(serverAddress, timeoutMillis);
            long endTime = System.currentTimeMillis();

            if (isReachable) {
                long latency = endTime - startTime;
                totalLatency += latency;
                minLatency = Math.min(minLatency, latency);
                maxLatency = Math.max(maxLatency, latency);
                System.out.print("\rLatency: " + latency + "ms");
            } else {
                System.out.println("Server is not reachable");
            }

            try {
                Thread.sleep(timeoutMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted");
            }
        }

        if (numberOfRequests > 0) {
            double averageLatency = (double) totalLatency / numberOfRequests;
            System.out.println();
            System.out.println("Server - " + serverAddress);
            System.out.println("MIN: " + minLatency + " AVG: " + averageLatency + " MAX: " + maxLatency);
        }
    }

    private static boolean pingServer(String serverAddress, int timeoutMillis) {
        try {
            return InetAddress.getByName(serverAddress).isReachable(timeoutMillis);
        } catch (IOException e) {
            System.err.println("Error while pinging server: " + e.getMessage());
            return false;
        }
    }
}
