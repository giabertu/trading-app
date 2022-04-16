public class DigitOnlyException extends RuntimeException {

    public DigitOnlyException(){
        super("The input is only made of digits. Not possible to continue.");
    }
    
}
