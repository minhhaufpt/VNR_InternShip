package com.core.vnr_internship.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "khoahoc")
public class KhoaHoc  implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "tenkhoahoc")
    String tenKhoaHoc;
    @OneToMany(mappedBy = "khoahoc")
    List<MonHoc> monHoc;
}
