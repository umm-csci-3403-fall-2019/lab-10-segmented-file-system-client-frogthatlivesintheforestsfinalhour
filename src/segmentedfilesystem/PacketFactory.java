package segmentedfilesystem;

import java.net.DatagramPacket;

class PacketFactory{
    public static Packet getPacket(DatagramPacket packet){
        if(packet.getData()[0] % 2 == 0){
            return new HeaderPacket(packet);
        }
        else{
            return new DataPacket(packet);
        }
    }
}