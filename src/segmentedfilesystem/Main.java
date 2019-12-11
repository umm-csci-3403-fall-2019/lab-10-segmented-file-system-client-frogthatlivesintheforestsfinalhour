package segmentedfilesystem;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        int port = 6014;
        InetAddress address;
        DatagramPacket packet;
        byte[] sendBuf = new byte[256];

        /*if (args.length != 1) {
            System.out.println("Usage: java Main <csci-4409.morris.umn.edu>");
            return;
        }*/

        //array for the assembly of the final product (type DatagramPacket is subject to change)
        ArrayList<DataPacket> finalResult = new ArrayList<DataPacket>(1);
        try {
            //socket connection to the server
            DatagramSocket socket = new DatagramSocket();
            address = InetAddress.getByName("csci-4409.morris.umn.edu");
            packet = new DatagramPacket(sendBuf, sendBuf.length, address, port);
            socket.send(packet);

            //eventually we would like to place a while loop (maybe while there are still files not received yet?)
            //receiving the packet from the server
            byte[] buf = new byte[1028];
            DatagramPacket receivedPacket = new DatagramPacket();
            socket.receive(receivedPacket);
            finalResult.add(receivedPacket);

            //Printing the data received for debugging purposes
            String received = new String(receivedPacket.getData(), 0, receivedPacket.getDataLength());
            System.out.println(received);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

}
