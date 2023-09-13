package com.core.vnr_internship.restapi;

import com.core.vnr_internship.daos.MonHocDAO;
import com.core.vnr_internship.entitys.MonHoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin("*")
@RestController
public class MonHocRestController {
    @Autowired
    MonHocDAO mhDAO;

    @GetMapping("/restapi/monhoc")
    public List<MonHoc> getAll() {
        return mhDAO.findAll();
    }

    @GetMapping("/restapi/monhoc/{id}")
    public List<MonHoc> getById(@PathVariable("id") Integer id) {
        return mhDAO.findByKhoaHocId(id);
    }

    @PostMapping("/restapi/monhoc")
    public MonHoc POST(@RequestBody MonHoc monhoc) {
        if (mhDAO.findById(monhoc.getId()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "monhoc exist");
        }
        mhDAO.save(monhoc);
        return monhoc;
    }

    @PutMapping("/restapi/monhoc")
    public MonHoc PUT(@RequestBody MonHoc monhoc) {
        if (!(mhDAO.findById(monhoc.getId()) != null)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "monhoc not found");
        }
        mhDAO.save(monhoc);
        return monhoc;
    }
    @DeleteMapping("/restapi/monhoc/{id}")
    public void DELETE(@PathVariable("id") Integer id) {
        if (!(mhDAO.findById(id) != null)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "monhoc not found");
        }
        mhDAO.deleteById(id);
    }
}
