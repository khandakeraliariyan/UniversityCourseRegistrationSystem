package fee;

public class BaseFee implements Fee {
    @Override
    public double getFee() {
        return 3000;
    }
}
