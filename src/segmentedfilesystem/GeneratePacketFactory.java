package segmentedfilesystem;

class GeneratePacketFactory{
    public Packet generatePacket(int status, int ID, byte[] info, int packNum){
        if(status % 2 == 0){
            return new HeaderPacket(status, ID, info);
        }
        else{
            return new DataPacket(status, ID, info, packNum);
        }
    }
}