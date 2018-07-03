package Socketexample;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
 
public class ServerExample {
    public static void main(String... args){
        //�ڵ� close
        try(ServerSocket server = new ServerSocket()){
            // ���� �ʱ�ȭ
            InetSocketAddress ipep = new InetSocketAddress(9999);
            server.bind(ipep);
             
            System.out.println("Initialize complate");
             
            //LISTEN ���
            Socket client = server.accept();
            System.out.println("Connection");
             
            //send,reciever ��Ʈ�� �޾ƿ���
            //�ڵ� close
            try(OutputStream sender = client.getOutputStream();
                InputStream reciever = client.getInputStream();){
                //Ŭ���̾�Ʈ�� hello world �޽��� ������
                //11byte ������
                String message = "hello world";
                byte[] data = message.getBytes();
                sender.write(data, 0, data.length);
                 
                //Ŭ���̾�Ʈ�κ��� �޽��� �ޱ�
                //2byte ������
                data = new byte[2];
                reciever.read(data, 0, data.length);
                 
                //���� �޽��� ���
                message = new String(data);
                String out = String.format("recieve - %s", message);
                System.out.println(out);
            }
        }catch(Throwable e){
            e.printStackTrace();
        }
    }
}