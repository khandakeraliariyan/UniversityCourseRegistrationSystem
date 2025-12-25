package fee;

public class ExamFeeDecorator extends FeeDecorator {

    public ExamFeeDecorator(Fee fee) {
        super(fee);
    }

    @Override
    public double getFee() {
        return fee.getFee() + 500;
    }
}
