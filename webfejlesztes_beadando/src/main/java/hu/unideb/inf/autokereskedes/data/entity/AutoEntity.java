package hu.unideb.inf.autokereskedes.data.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "auto")
public class AutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "gyarto", nullable = false)
    private String gyarto;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "evjarat_ip", nullable = false)
    private Double evjarat;
    @Column(name = "ar", nullable = false)
    private Double ar;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Auto_extrak",
        joinColumns = {@JoinColumn(name = "auto_id")},
        inverseJoinColumns = {@JoinColumn(name = "extra_id")}
    )
    private List<ExtrakEntity> extrak;


    public AutoEntity() {
    }
    public AutoEntity(Long id, String gyarto, String model, Double evjarat, Double ar) {
        this.id = id;
        this.gyarto = gyarto;
        this.model = model;
        this.evjarat = evjarat;
        this.ar = ar;
    }

    public Long getId() { return id;}

    public void setId(Long id) { this.id = id;}

    public String getGyarto() { return gyarto;}

    public void setGyarto(String gyarto) {this.gyarto = gyarto;}

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}

    public Double getAr() {return ar;}

    public void setAr(Double ar) {this.ar = ar;}

    public Double getEvjarat() {
        return evjarat;
    }

    public void setEvjarat(Double evjarat) {
        this.evjarat = evjarat;
    }

    public List<ExtrakEntity> getExtrak() {
        return extrak;
    }

    public void setExtrak(List<ExtrakEntity> extrak) {
        this.extrak = extrak;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoEntity that = (AutoEntity) o;
        return id == that.id && Objects.equals(gyarto, that.gyarto) && Objects.equals(model, that.model) && Objects.equals(evjarat, that.evjarat) && Objects.equals(ar, that.ar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gyarto, model, evjarat, ar);
    }
}
