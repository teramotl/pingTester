public class PingConfiguration {
    private String serverAddress;
    private int requestSendAmount;
    private int timeoutMillis;

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
