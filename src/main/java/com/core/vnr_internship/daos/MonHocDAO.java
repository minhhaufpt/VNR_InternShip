package com.core.vnr_internship.daos;

import com.core.vnr_internship.entitys.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MonHocDAO extends JpaRepository<MonHoc, Integer> {
    @Query("SELECT mh FROM MonHoc mh where  mh.khoahoc.id = :khoahocid")
    List<MonHoc> findByKhoaHocId(Integer khoahocid);
}
