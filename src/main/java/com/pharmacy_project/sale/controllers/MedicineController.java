package com.pharmacy_project.sale.controllers;

import com.pharmacy_project.sale.domain.Medicine;
import com.pharmacy_project.sale.services.MedicineService;
import com.pharmacy_project.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/medicine")
public class MedicineController {


    private MedicineService medicineService;

    @PostMapping
    public ResponseEntity<Medicine> createMedicine(@RequestBody Medicine medicine) {
        Medicine medicine1 = medicineService.saveMedicine(medicine);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicine1);

    }

    @GetMapping("/medicines")
    public ResponseEntity<List<Medicine>> getAllMedicines() {
        List<Medicine> medicines = medicineService.getAllMedicines();
        return ResponseEntity.ok().body(medicines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
        Medicine medicine = medicineService.getMedicineById(id);
        return ResponseEntity.ok(medicine);
    }

    @GetMapping("/byname/search")
    public ResponseEntity<Medicine> getMedicineByName(@RequestParam String name) {
        Medicine medicine = medicineService.getMedicineByName(name);
        return ResponseEntity.ok(medicine);
    }


    @PutMapping("/updateMedicine/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestParam int additionalStock, @RequestParam double newPrice) {
        Medicine updatedMedicine = medicineService.updateExistingMedicine(id, additionalStock, newPrice);
        return ResponseEntity.ok(updatedMedicine);
    }
}
