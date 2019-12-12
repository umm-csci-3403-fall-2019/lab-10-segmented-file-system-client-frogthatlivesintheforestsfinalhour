package segmentedfilesystem;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        try {
            //socket connection to the server
            DatagramSocket socket = new DatagramSocket();
            address = InetAddress.getByName("csci-4409.morris.umn.edu");
            packet = new DatagramPacket(sendBuf, sendBuf.length, address, port);
            socket.send(packet);

            //array for the assembly of the final product (type DatagramPacket is subject to change)
            ArrayList<DataPacket> datapacketCollection = new ArrayList<DataPacket>(1);
            ArrayList<HeaderPacket> headerpacketCollection = new ArrayList<HeaderPacket>(1);

            //eventually we would like to place a while loop (maybe while there are still files not received yet?)
            //receiving the packet from the server

            int loopTerminator = Integer.MAX_VALUE;
            byte[] fileList = new byte[3];
            while(0 < loopTerminator){
                byte[] buf = new byte[1028];
                DatagramPacket receivedPacket = new DatagramPacket(buf, buf.length);
                socket.receive(receivedPacket);

                Packet loopPacket = PacketFactory.getPacket(receivedPacket);

                if(loopPacket.isHeader){
                    headerpacketCollection.add((HeaderPacket) loopPacket);
                }
                else{
                    datapacketCollection.add((DataPacket) loopPacket);
                }

                Map<Byte, Packet> fileMap = new HashMap<>();
                fileMap.put(loopPacket.getFileID(), loopPacket);

                assignToFile(loopPacket.getFileID(), fileList);

                //Printing the data received for debugging purposes
                String received = new String(loopPacket.getData(), 0, loopPacket.getDataLength());
                System.out.println(received);
            }

        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    private static int assignToFile(byte fileID, byte[] fileList){
        for (int i=0; i<fileList.length; i++){
            if(fileList[i] == fileID){
                return i;
            }
        }
    }

}
