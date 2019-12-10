package segmentedfilesystem;

public class DataPacket extends Packet{
    private int packetNumber;

    public DataPacket(int status, int ID, byte[] info, int packNum){
        super(status, ID, info);
        packetNumber = packNum;
    }

    public int getPacketNumber(){
        return packetNumber;
    }
}