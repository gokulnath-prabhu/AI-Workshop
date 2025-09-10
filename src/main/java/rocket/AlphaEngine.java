package rocket;

public class AlphaEngine implements Engine {
    @Override
    public int getMass() {
        return 5000;
    }

    @Override
    public int getLiftPower() {
        return 50000;
    }

    @Override
    public String getType() {
        return "Alpha";
    }
}
