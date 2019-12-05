package segmentedfilesystem;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class QuoteClient {
    
    public static void main(String[] args) {
        int port = 6014;
        InetAddress address;
        DatagramPacket packet;
        byte[] sendBuf = new byte[256];

        /*if (args.length != 1) {
            System.out.println("Usage: java QuoteClient <csci-4409.morris.umn.edu>");
            return;
        }*/
        try {
            DatagramSocket socket = new DatagramSocket();
            address = InetAddress.getByName("csci-4409.morris.umn.edu");
            packet = new DatagramPacket(sendBuf, sendBuf.length, address, port);
            socket.send(packet);

            byte[] buf = new byte[1028];
            DatagramPacket receivedPacket = new DatagramPacket(buf, buf.length);
            socket.receive(receivedPacket);
            String received = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
            System.out.println(received);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

}
