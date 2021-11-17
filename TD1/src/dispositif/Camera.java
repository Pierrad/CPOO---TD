package dispositif;

public class Camera extends Dispositif {
    private Integer battery;
    private Boolean isActivate;

    public Camera(String name, Integer id) {
        super(name, id);
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public Boolean getIsActivate() {
        return isActivate;
    }

    public void setIsActivate(Boolean i) {
        this.isActivate = i;
    }

    public Integer chargeBatterie() {
        return this.battery;
    }

    public Boolean allumer() {
        this.setState(true);
        return this.getState();
    }

    public void activate() {
        this.setIsActivate(true);
    }

    public Boolean desactiver() {
        this.setIsActivate(false);
        return this.getState();
    }

    public void visionnerFlux() {
        System.out.println("Flux");
    }

    public Boolean eteindre() {
        this.setState(false);
        return this.getState();
    }


}
