package fee;

public abstract class FeeDecorator implements Fee {
    protected Fee fee;

    public FeeDecorator(Fee fee) {
        this.fee = fee;
    }
}
