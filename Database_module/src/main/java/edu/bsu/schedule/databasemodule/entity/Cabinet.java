package edu.bsu.schedule.databasemodule.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Cabinets")
public class Cabinet implements Serializable{
    private static final long serialVersionUID = 549508310181708305L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "cabinet_seq")
    @SequenceGenerator(name = "cabinet_seq", sequenceName = "seq_cabinets_id")
    @Column(name="CABINET_ID")
    private Long cabinetId;

    @Column(name="CABINET")
    @NotBlank
    @Length(max = 10)
    private String cabinetNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabinet")
    private List<Subject> subject;

    public Long getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(Long cabinetId) {
        this.cabinetId = cabinetId;
    }

    public String getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(String cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }
}

