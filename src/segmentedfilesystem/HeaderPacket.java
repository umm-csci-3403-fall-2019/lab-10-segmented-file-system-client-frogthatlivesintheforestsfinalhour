package segmentedfilesystem;

public class HeaderPacket extends Packet{
    private int packetNumber;

    public HeaderPacket(int status, int ID, byte[] info){
        super(status, ID, info);
    }
}