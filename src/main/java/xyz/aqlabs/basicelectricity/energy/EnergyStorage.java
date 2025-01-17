package xyz.aqlabs.basicelectricity.energy;

public class EnergyStorage implements IEnergyStorage{

    private int energy;
    private final int capacity;

    public EnergyStorage(int capacity) {
        this.capacity = capacity;
        this.energy = 0;
    }

    @Override
    public int receiveEnergy(int amount, boolean simulate) {
        int energyReceived = Math.min(capacity - energy, amount);
        if (!simulate) {
            energy += energyReceived;
        }
        return energyReceived;
    }

    @Override
    public int extractEnergy(int amount, boolean simulate) {
        int energyExtracted = Math.min(energy, amount);
        if (!simulate) {
            energy -= energyExtracted;
        }
        return energyExtracted;
    }

    @Override
    public int getStoredEnergy() {
        return energy;
    }

    @Override
    public int getMaxEnergyStored() {
        return capacity;
    }

    @Override
    public boolean canReceive() {
        return energy < capacity;
    }

    @Override
    public boolean canExtract() {
        return energy > 0;
    }
}
