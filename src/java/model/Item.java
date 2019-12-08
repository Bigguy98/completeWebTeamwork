/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author vutha
 */
public class Item {
    private Integer id;
    private String name;
    private Long price;
    private String screen;
    private String selfieCamera;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getSelfieCamera() {
        return selfieCamera;
    }

    public void setSelfieCamera(String selfieCamera) {
        this.selfieCamera = selfieCamera;
    }

    public String getMainCamera() {
        return mainCamera;
    }

    public void setMainCamera(String mainCamera) {
        this.mainCamera = mainCamera;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    private String mainCamera;
    private String ram;
    private String rom;
    private String gpu;
    private String cpu;
    private String battery;
    private String os;
    private String sim;
    private String image;

    public Item() {
    }

    public Item(Integer id, String name, Long price, String screen, String selfieCamera, String mainCamera, String ram, String rom, String gpu, String cpu, String battery, String os, String sim, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.screen = screen;
        this.selfieCamera = selfieCamera;
        this.mainCamera = mainCamera;
        this.ram = ram;
        this.rom = rom;
        this.gpu = gpu;
        this.cpu = cpu;
        this.battery = battery;
        this.os = os;
        this.sim = sim;
        this.image = image;
    }

    public Long getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }

    public Item(String name, Long price, String screen, String selfieCamera, String mainCamera, String ram, String rom, String gpu, String cpu, String battery, String os, String sim, String image) {
        this.name = name;
        this.price = price;
        this.screen = screen;
        this.selfieCamera = selfieCamera;
        this.mainCamera = mainCamera;
        this.ram = ram;
        this.rom = rom;
        this.gpu = gpu;
        this.cpu = cpu;
        this.battery = battery;
        this.os = os;
        this.sim = sim;
        this.image = image;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    
    
}
