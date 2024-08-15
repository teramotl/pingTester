public class MultithreadingConnection extends PingTester implements Runnable {

    private String serverAddress;

    public MultithreadingConnection(String serverAddress) {
        this.serverAddress = serverAddress;
    }
    @Override
    public void run() {
        connectTo(serverAddress);
    }
}
