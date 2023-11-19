public class AmountDataException extends DataException{
    
    private final int lengthData;


    public int getLengthData() {
        return lengthData;
    }

    public AmountDataException(String massage, int lengthData) {
        super(massage);
        this.lengthData = lengthData;
    }

    @Override
    public String toString() {
        return "AmountDataException [lengthData=" + lengthData + "]";
    }

    
}
