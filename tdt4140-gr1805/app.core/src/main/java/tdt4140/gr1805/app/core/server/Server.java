package tdt4140.gr1805.app.core.server;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import tdt4140.gr1805.app.core.data.Database;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    Database db;


    public static void main(String argv[]) throws Exception {
        ServerSocket server = new ServerSocket(6789);

        while (true) {
            Socket socket = server.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            JsonParser parser = new JsonFactory().
/*            BufferedReader inFromClient =
                    new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            String line = inFromClient.readLine();
            System.out.println(line);*/
        }
    }
}
