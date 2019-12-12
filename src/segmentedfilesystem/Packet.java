package segmentedfilesystem;

import java.net.DatagramPacket;
import java.util.Arrays;

public abstract class Packet{
    private byte status;
    private byte fileID;
    boolean isHeader = false;

    public Packet(){
    }

    public byte getStatusByte(){ return status; }
    public byte getFileID(){ return fileID; }
}