package oops.challenge;

public class FreezingAndBoilingPoint {
    private int temperature;

    public FreezingAndBoilingPoint(int temperature) {
        this.temperature = temperature;
    }

    public boolean isEthylFreezing() {
        return this.temperature <= -173;
    }

    public boolean isEthylBoiling() {
        return this.temperature >= 173;
    }

    public boolean isOxygenFreezing() {
        return this.temperature <= -362;
    }

    public boolean isOxygenBoiling(){
        return this.temperature >=362;
    }
    public boolean isWaterFreezing(){
        return this.temperature <= 32;
    }
    public boolean isWaterBoiling(){
        return this.temperature >=32;
    }

}
