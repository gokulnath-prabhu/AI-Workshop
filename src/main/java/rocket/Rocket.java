package rocket;

public class Rocket {
    public enum Status { READY, LAUNCHED, FAILED }

    private final String model;
    private final int baseMass;
    private int fuelLevel; // 0-100 (%)
    private final Engine engine;
    private Status status;

    public Rocket(String model, int baseMass, int fuelLevel, Engine engine) {
        this.model = model;
        this.baseMass = baseMass;
        this.fuelLevel = fuelLevel;
        this.engine = engine;
        this.status = Status.READY;
    }

    // Backward compatibility constructor for Stage 1
    public Rocket(String model, int baseMass, int fuelLevel) {
        this(model, baseMass, fuelLevel, null);
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

    public Engine getEngine() {
        return engine;
    }

    public int getLaunchMass() {
        return baseMass + (engine != null ? engine.getMass() : 0);
    }

    public Status getStatus() {
        return status;
    }

    public boolean verifyReadiness() {
        return fuelLevel == 100;
    }

    public boolean startLiftoff() {
        if (!verifyReadiness()) {
            status = Status.FAILED;
            return false;
        }
        if (engine == null || getLaunchMass() > engine.getLiftPower()) {
            status = Status.FAILED;
            return false;
        }
        status = Status.LAUNCHED;
        return true;
    }
}
