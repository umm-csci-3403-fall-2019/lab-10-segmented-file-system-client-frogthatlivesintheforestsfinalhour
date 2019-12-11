package segmentedfilesystem;

import java.net.DatagramPacket;

class GeneratePacketFactory{
    public Object generatePacket(DatagramPacket packet){
        if(packet.getData()[0] % 2 == 0){
            return new HeaderPacket(packet);
        }
        else{
            return new DataPacket(packet);
        }
    }
}