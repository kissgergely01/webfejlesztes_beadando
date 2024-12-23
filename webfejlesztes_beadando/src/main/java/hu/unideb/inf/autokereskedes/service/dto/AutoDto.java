package hu.unideb.inf.autokereskedes.service.dto;

import java.util.Date;
import java.util.Objects;

public class AutoDto {

    private Long id;
    private String gyarto;
    private String model;
    private Double evjarat;
    private Double ar;

    public AutoDto(Long id, String gyarto, String model, Double evjarat, Double ar) {
        this.id = id;
        this.gyarto = gyarto;
        this.model = model;
        this.evjarat = evjarat;
        this.ar = ar;
    }

    public AutoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGyarto() {
        return gyarto;
    }

    public void setGyarto(String gyarto) {
        this.gyarto = gyarto;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getEvjarat() {
        return evjarat;
    }

    public void setEvjarat(Double evjarat) {
        this.evjarat = evjarat;
    }

    public Double getAr() {
        return ar;
    }

    public void setAr(Double ar) {
        this.ar = ar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoDto that = (AutoDto) o;
        return id == that.id && Objects.equals(gyarto, that.gyarto) && Objects.equals(model, that.model) && Objects.equals(evjarat, that.evjarat) && Objects.equals(ar, that.ar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gyarto, model, evjarat, ar);
    }
}
