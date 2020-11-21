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

/**
 *
 * @author Santa
 */
public class client2 {

    public static String daochuoi(String s) {
        String tmp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            tmp = tmp + s.charAt(i);
        }
        return tmp;
    }

    public static int demTu(String s1, String s2) {
        int c = 0;
        boolean ok;
        for (int i = 0; i < s1.length(); i++) {
            int tmp = i;
            if (s1.charAt(tmp) == s2.charAt(0)) {
                ok=true;
                for (int k = 1; k < s2.length(); k++) {
                    tmp++;
                    if (s1.charAt(tmp) == s2.charAt(k)) {
                        continue;
                    }else {
                        ok=false;
                        break;
                    }
                }
                if(ok) {
                    c++;
                }
            }
        }

        return c;
    }

    public static void main(String[] args) throws IOException {
        try {
            Socket client = new Socket("192.168.0.106", 11001);
            System.out.println("Nogul");
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            InputStream inputStream = client.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
             
            out.writeUTF("B17DCCN406");
            out.writeUTF("Bui Nguyen Luong");
            out.writeInt(2);

            int code;
            String x1, x2, x3;
            code = in.readInt();
            System.out.println(code);
            if (code == 0) {

                x1 = in.readUTF();
                out.writeUTF(daochuoi(x1));
                x2 = in.readUTF();
                x3 = in.readUTF();
                out.writeInt(demTu(x2, x3));
            } else if (code == 1) {
                x2 = in.readUTF();
                x3 = in.readUTF();
                out.writeInt(demTu(x2, x3));
                x1 = in.readUTF();
                out.writeUTF(daochuoi(x1));
            }

            in.close();
            out.close();
            objectInputStream.close();
            client.close();
        } catch (IOException e) {
        }
    }

}
