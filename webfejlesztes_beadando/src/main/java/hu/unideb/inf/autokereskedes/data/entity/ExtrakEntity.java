package hu.unideb.inf.autokereskedes.data.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "extra")
public class ExtrakEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "allapot")
    private String allapot;
    @Column(name = "klima")
    private Boolean klima;
    @Column(name = "szervizDatum")
    private Date szervizDatum;

    @ManyToMany(mappedBy = "extrak")
    private List<AutoEntity> autok;

    public ExtrakEntity(long id, String allapot, Boolean klima, Date szervizDatum) {
        this.id = id;
        this.allapot = allapot;
        this.klima = klima;
        this.szervizDatum = szervizDatum;
    }

    public ExtrakEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAllapot() {
        return allapot;
    }

    public void setAllapot(String allapot) {
        this.allapot = allapot;
    }

    public Boolean getKlima() {
        return klima;
    }

    public void setKlima(Boolean klima) {
        this.klima = klima;
    }

    public Date getSzervizDatum() {
        return szervizDatum;
    }

    public void setSzervizDatum(Date szervizDatum) {
        this.szervizDatum = szervizDatum;
    }

    public List<AutoEntity> getAutok() {
        return autok;
    }

    public void setAutok(List<AutoEntity> autok) {
        this.autok = autok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtrakEntity that = (ExtrakEntity) o;
        return id == that.id && Objects.equals(allapot, that.allapot) && Objects.equals(klima, that.klima)&& Objects.equals(szervizDatum, that.szervizDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, allapot, klima, szervizDatum);
    }
}
