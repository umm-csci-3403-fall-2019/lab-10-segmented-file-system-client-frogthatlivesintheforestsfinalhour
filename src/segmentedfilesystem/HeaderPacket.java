package segmentedfilesystem;

import java.net.DatagramPacket;
import java.util.Arrays;

public class HeaderPacket extends Packet{

    private byte status;
    private byte fileID;
    private byte[] data;

    public HeaderPacket(DatagramPacket packet){
        status = packet.getData()[0];
        fileID = packet.getData()[1];
        data = Arrays.copyOfRange(packet.getData(),3,packet.getLength());
        isHeader = true;
    }

    public byte getStatusByte(){ return status; }
    public byte getFileID(){ return fileID; }
    public byte[] getData(){ return data; }
    public int getDataLength(){ return data.length; }
}