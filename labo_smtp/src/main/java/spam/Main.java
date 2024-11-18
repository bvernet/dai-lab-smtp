package spam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.Time;

public class Main {
    final static String HOST_NAME = "localhost";
    final static int SERVER_PORT = 1025;

    final static String END_LINE = "\n";

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST_NAME, SERVER_PORT);
            var in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            var out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            BufferedReader terminalInput = new BufferedReader(new InputStreamReader(System.in))) {

            

            while (true) {
                StringBuilder answers = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null && line.length() != 0) {

                    answers.append("- " + line + "\n");
                    if (line.charAt(3) == ' ') break;
                }
                System.out.print(answers.toString());

                out.write(terminalInput.readLine() + END_LINE);
                out.flush();
            }

        } catch (Exception e) {

        }
        
    }
    /* 
    public static void main(String[] args) {
        if (args.length < 1) return;
        String domainName = args[0];
        
        String hostname = "whois.internic.net";
        int port = 43;
        
        try (Socket socket = new Socket(hostname, port)) {
            
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println(domainName);
            
            InputStream input = socket.getInputStream();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            
            String line;
            
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (UnknownHostException ex) {
            
            System.out.println("Server not found: " + ex.getMessage());
            
        } catch (IOException ex) {
            
            System.out.println("I/O error: " + ex.getMessage());
        }
    }*/
}