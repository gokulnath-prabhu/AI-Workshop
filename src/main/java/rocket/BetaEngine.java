package rocket;

public class BetaEngine implements Engine {
    @Override
    public int getMass() {
        return 10000;
    }

    @Override
    public int getLiftPower() {
        return 150000;
    }

    @Override
    public String getType() {
        return "Beta";
    }
}
