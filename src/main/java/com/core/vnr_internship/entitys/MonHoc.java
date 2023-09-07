package com.core.vnr_internship.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "monhoc")
public class MonHoc implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "tenmonhoc")
    String tenMonHoc;
    @Column(name = "mota")
    String moTa;
    @ManyToOne
    @JoinColumn(name = "khoahocid")
    KhoaHoc khoahoc;
}
