/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocket;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/**
 *
 * @author puggioni.riccardo
 */
public class ClientSocket {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String a;
        boolean b = true;
        try {
            Socket clientSocket = new Socket("10.1.33.19", 5000);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            do{
            System.out.println("dì qualcosa al server:");
            a = sc.next();
            out.println(a);
            String resp = in.readLine();
            if (a == "stop") {
                System.out.println("addio");
                in.close();
                out.close();
                clientSocket.close();
                b = false;
            } else {
                a.toUpperCase();
                resp = a;
                System.out.println("risposta del server: " + resp);
            }
            }while(b = true);

        } catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
