package segmentedfilesystem;

public abstract class Packet{
    private int statusByte;
    private int fileID;
    private byte[] data;

    public Packet(int status, int ID, byte[] info){
        statusByte = status;
        ID = fileID;
        data = info;
    }

    public int getStatusByte(){
        return statusByte;
    }
    public int getFileID(){
        return fileID;
    }
    public byte[] getData(){
        return data;
    }
    public int getDataLength(){
        return data.length;
    }
}