package brucephillips.java8examples;

public class Metal {

    public enum MetalType {

        GOLD, SILVER
    };
    
    private final MetalType type;
    
    private final int value;

    public Metal(final MetalType metalType, final int metalValue) {
        
        type = metalType;
        
        value = metalValue;
    }

    public MetalType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
