package dispositif;

public class Camera extends Dispositif {
    private Integer battery;

    public Camera(String name, Integer id) {
        super(name, id);
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public Integer chargeBatterie() {
        return this.battery;
    }

    public Boolean allumer() {
        this.setState(true);
        return this.getState();
    }

    public void visionnerFlux() {
        System.out.println("Flux");
    }

    public Boolean eteindre() {
        this.setState(false);
        return this.getState();
    }
    
    public Boolean activer() {
        this.setState2(true);
        return this.getState2();
    }
    
    public Boolean desactiver() {
        this.setState2(false);
        return this.getState2();
    }
}
