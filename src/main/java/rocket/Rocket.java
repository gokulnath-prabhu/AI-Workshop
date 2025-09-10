package rocket;

import java.util.function.BooleanSupplier;

public class Rocket {
    public enum Status { READY, LAUNCHED, FAILED }
    public enum MissionOutcome { NONE, SUCCESS, FAILED, RISKY_SUCCESS, RISKY_FAILED }

    private final String model;
    private final int baseMass;
    private int fuelLevel; // 0-100 (%)
    private final Engine engine;
    private Status status;
    private int cargoMass = 0;
    private MissionOutcome outcome = MissionOutcome.NONE;
    private BooleanSupplier randomProvider = () -> Math.random() < 0.5; // default 50% chance
    // For testability: allow injection of random provider
    public void setRandomProvider(BooleanSupplier randomProvider) {
        this.randomProvider = randomProvider;
    }

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


    public int getCargoMass() {
        return cargoMass;
    }

    public int getLaunchMass() {
        return baseMass + (engine != null ? engine.getMass() : 0) + cargoMass;
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
            outcome = MissionOutcome.FAILED;
            return false;
        }
        if (engine == null || getLaunchMass() > engine.getLiftPower()) {
            status = Status.FAILED;
            outcome = MissionOutcome.FAILED;
            return false;
        }
        // Risky launch: within 5% of engine lift
        double lift = engine.getLiftPower();
        double mass = getLaunchMass();
        boolean risky = (lift - mass) / lift <= 0.05;
        if (risky) {
            if (randomProvider.getAsBoolean()) {
                status = Status.LAUNCHED;
                outcome = MissionOutcome.RISKY_SUCCESS;
                return true;
            } else {
                status = Status.FAILED;
                outcome = MissionOutcome.RISKY_FAILED;
                return false;
            }
        } else {
            status = Status.LAUNCHED;
            outcome = MissionOutcome.SUCCESS;
            return true;
        }
    }
    public MissionOutcome getMissionOutcome() {
        return outcome;
    }

    public String getMissionSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("Model: ").append(model).append("\n");
        sb.append("Engine: ").append(engine != null ? engine.getType() : "None").append("\n");
        sb.append("Cargo Mass: ").append(cargoMass).append(" kg\n");
        sb.append("Launch Mass: ").append(getLaunchMass()).append(" kg\n");
        sb.append("Status: ").append(status).append("\n");
        sb.append("Mission Outcome: ").append(outcome).append("\n");
        return sb.toString();
    }

    public void loadItem(int itemMass) {
        if (status == Status.LAUNCHED) {
            throw new IllegalStateException("Cannot load cargo after launch");
        }
        if (itemMass <= 0) {
            throw new IllegalArgumentException("Cargo mass must be positive");
        }
        cargoMass += itemMass;
    }
}
