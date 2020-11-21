
package client;
import java.io.IOException;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;
public class UDPclient {
// khai bao socket cho client, cong gui va nhan du lieu
    DatagramSocket mySocket = null;
    int port = 9910;
// Tao ket noi

    public void connection() {
        try {
            mySocket = new DatagramSocket(port);
        } catch (SocketException e) {
            System.err.println(e);
        }
    }

    public void send(String str) {
        if (mySocket != null) {
            byte[] sendData = new byte[1024]; // bo dem gui dl
            try {
                InetAddress IPAddress
                        = InetAddress.getByName("192.168.0.106");
                sendData = str.getBytes();
                DatagramPacket sendPacket
                        = new DatagramPacket(sendData,
                                sendData.length, IPAddress, port);
                mySocket.send(sendPacket);
            } catch (SocketException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    public String receive() {
        if (mySocket != null) {
            byte[] receiveData = new byte[1024]; // bo dem nhan dl
            try {
                DatagramPacket receivePacket
                        = new DatagramPacket(receiveData,
                                receiveData.length);
                mySocket.receive(receivePacket);
                return new String(receivePacket.getData());
            } catch (SocketException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        return null;
    }

    public void close() {
        if (mySocket != null) {
            try {
                mySocket.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
          public static void main (String[] args){
           UDPclient ud =new UDPclient();
           ud.connection();
           ud.send("LuongCn10");
           System.out.println(ud.receive());
           ud.close();
}
}
