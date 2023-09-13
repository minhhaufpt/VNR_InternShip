package com.core.vnr_internship.restapi;

import com.core.vnr_internship.daos.KhoaHocDAO;
import com.core.vnr_internship.entitys.KhoaHoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin("*")
@RestController
public class KhoaHocRestController {
    @Autowired
    KhoaHocDAO khDAO;

    @GetMapping("/restapi/khoahoc")
    public List<KhoaHoc> getAll() {
        return khDAO.findAll();
    }

    @PostMapping("/restapi/khoahoc")
    public KhoaHoc POST(@RequestBody KhoaHoc khoahoc) {
        if (khDAO.findById(khoahoc.getId()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Khoahoc exist");
        }
        khDAO.save(khoahoc);
        return khoahoc;
    }

    @PutMapping("/restapi/khoahoc")
    public KhoaHoc PUT(@RequestBody KhoaHoc khoahoc) {
        if (!(khDAO.findById(khoahoc.getId()) != null)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Khoahoc not found");
        }
        khDAO.save(khoahoc);
        return khoahoc;
    }
    @DeleteMapping("/restapi/khoahoc/{id}")
    public void DELETE(@PathVariable("id") Integer id) {
        if (!(khDAO.findById(id) != null)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Khoahoc not found");
        }
        khDAO.deleteById(id);
    }
}
