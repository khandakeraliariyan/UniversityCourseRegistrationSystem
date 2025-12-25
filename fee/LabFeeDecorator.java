package fee;

public class LabFeeDecorator extends FeeDecorator {

    public LabFeeDecorator(Fee fee) {
        super(fee);
    }

    @Override
    public double getFee() {
        return fee.getFee() + 1000;
    }
}
