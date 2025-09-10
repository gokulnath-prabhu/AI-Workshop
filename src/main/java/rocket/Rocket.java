package rocket;

public class Rocket {
    private final String model;
    private final int baseMass;
    private int fuelLevel; // 0-100 (%)

    public Rocket(String model, int baseMass, int fuelLevel) {
        this.model = model;
        this.baseMass = baseMass;
        this.fuelLevel = fuelLevel;
    }

    public String getModel() {
        return model;
    }

    public int getBaseMass() {
        return baseMass;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public boolean verifyReadiness() {
        return fuelLevel == 100;
    }
}
