package com.core.vnr_internship.daos;

import com.core.vnr_internship.entitys.KhoaHoc;
import com.core.vnr_internship.entitys.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhoaHocDAO  extends JpaRepository<KhoaHoc, Integer> {
}
