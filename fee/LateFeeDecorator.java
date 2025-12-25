package fee;

public class LateFeeDecorator extends FeeDecorator {

    public LateFeeDecorator(Fee fee) {
        super(fee);
    }

    @Override
    public double getFee() {
        return fee.getFee() + 300;
    }
}
