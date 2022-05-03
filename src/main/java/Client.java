import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Thread {

    public void run() {
        try {
            String host = "localhost";
            int port = 8080;
            try (Socket clientSocket = new Socket(host, port);
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                out.println("Client\n");
                String resp = in.readLine();
                System.out.println(resp);
            }
            InetAddress inetAddress = InetAddress.getByName(host);
            System.out.println("Host: " + host + ", ip address: " + inetAddress.getHostAddress());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
