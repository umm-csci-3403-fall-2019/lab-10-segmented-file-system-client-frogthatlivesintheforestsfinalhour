package segmentedfilesystem;

import java.net.DatagramPacket;
import java.util.Arrays;

public class DataPacket extends Packet{

    private byte status;
    private byte fileID;
    private byte[] packetNumber = new byte[2];
    private byte[] data;

    public DataPacket(DatagramPacket packet){
        status = packet.getData()[0];
        fileID = packet.getData()[1];
        packetNumber[0] = packet.getData()[2];
        packetNumber[1] = packet.getData()[3];
        data = Arrays.copyOfRange(packet.getData(),4,packet.getLength());
        isHeader = false;
    }

    public byte getStatusByte(){
        return status;
    }
    public byte getFileID(){
        return fileID;
    }
    public byte[] getPacketNumber(){
        return packetNumber;
    }
    public byte[] getData(){
        return data;
    }
    public int getDataLength(){
        return data.length;
    }
}