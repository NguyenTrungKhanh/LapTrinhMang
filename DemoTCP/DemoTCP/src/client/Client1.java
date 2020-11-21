/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import model.Answer;
import model.Student;

/**
 *
 * @author Santa
 */
public class Client1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student student = new Student("B17DCCN406", "Bui Nguyen Luong", "192.168.0.130", 2);
        try {
            Socket client = new Socket("192.168.0.106", 11005);
     
            OutputStream outputStream = client.getOutputStream();
           // InputStream inputStream = client.getInputStream();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
          //  ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            objectOutputStream.writeObject(student);
            objectOutputStream.close();
        //    objectInputStream.close();
            client.close();
        } catch (IOException e) {
        }
    }
    
}
