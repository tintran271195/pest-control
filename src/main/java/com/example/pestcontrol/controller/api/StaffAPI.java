package com.example.pestcontrol.controller.api;

import com.example.pestcontrol.model.Staff;
import com.example.pestcontrol.service.Staff.IStaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/staff")
@RequiredArgsConstructor
public class StaffAPI {
    private final IStaffService staffService;

    @GetMapping()
    public ResponseEntity<Iterable<Staff>> getAllStaff() {
        Iterable<Staff> staffs = staffService.findAll();
        if (staffs == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(staffs, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id) {
        Optional<Staff> staff = staffService.findById(id);
        if (!staff.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(staff.get(), HttpStatus.OK);
        }
    }

    @PostMapping()
    public ResponseEntity<Staff> saveStaff(@RequestBody Staff staff) {
        return new ResponseEntity<>(staffService.save(staff), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Staff> deleteStaffId(@PathVariable Long id){
        Optional<Staff> staff = staffService.findById(id);
        if(!staff.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            staffService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
