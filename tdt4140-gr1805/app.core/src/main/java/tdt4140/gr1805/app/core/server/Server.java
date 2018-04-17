package tdt4140.gr1805.app.core.server;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import tdt4140.gr1805.app.core.data.DataPoint;
import tdt4140.gr1805.app.core.data.Database;
import tdt4140.gr1805.app.core.data.LatLong;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Server {
    private Database db;
    private JsonFactory factory;

    public Server(Database db) {
        this.db = db;

        this.factory = new ObjectMapper().getFactory();
        start();
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(6789)) {
            server.setReuseAddress(true);
            while (true) {
                Socket socket = server.accept();
                handleConnection(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleConnection (Socket socket){
        try (InputStream inputStream = socket.getInputStream()) {
            JsonParser parser = factory.createParser(inputStream);

            int id = 0;
            LocalDateTime timestamp = LocalDateTime.now();
            double pulse = 0;
            LatLong location = null;

            parser.nextToken();

            while (parser.nextToken() != JsonToken.END_OBJECT) {
                String name = parser.getCurrentName();
                switch (name) {
                    case "id":
                        id = parser.getValueAsInt();
                        break;
                    case "timestamp":
                        parser.nextToken();
                        int[] arr = parser.readValueAs(int[].class);
                        timestamp = LocalDateTime.of(arr[0], arr[1], arr[2], arr[3], arr[4]);
                        break;
                    case "pulse":
                        pulse = parser.getValueAsDouble();
                        break;
                    case "location":
                        parser.nextToken();
                        if (parser.getCurrentToken() == JsonToken.VALUE_NULL) {
                            location = null;
                        } else {
                            parser.nextToken();
                            parser.nextToken();
                            double latitude = parser.getValueAsDouble();
                            parser.nextToken();
                            parser.nextToken();
                            double longitude = parser.getValueAsDouble();
                            location = new LatLong(latitude, longitude);
                        }
                        break;
                }
            }
            inputStream.close();
            socket.close();

            DataPoint point = new DataPoint(id, timestamp, pulse, location);
            db.addPoint(point);
            System.out.println("Added: " + point + " to database");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
