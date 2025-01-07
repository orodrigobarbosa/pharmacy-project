package com.pharmacy_project.sale.services;

import com.pharmacy_project.sale.domain.Medicine;
import com.pharmacy_project.sale.repositories.MedicineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@AllArgsConstructor
@Service
public class MedicineService {

    private MedicineRepository medicineRepository;




    public Medicine saveMedicine(Medicine medicine) {
        Optional<Medicine> existingMedicine = medicineRepository.findByName(medicine.getName());
        //verifica se há a medicação por nome e atualiza preço e estoque
        if (existingMedicine.isPresent()) {
            Medicine updatedMedicine = existingMedicine.get();
            updatedMedicine.setStock(updatedMedicine.getStock() + medicine.getStock());
            updatedMedicine.setPrice(medicine.getPrice());
            return updatedMedicine;
        }// se nao, será salvo como um novo registro
        return medicineRepository.save(medicine);
    }


    //medoto para apenas atualizar
    public Medicine updateExistingMedicine(Long id, int additionalStock, double newPrice) {
        Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new RuntimeException("Medicin not found"));
        medicine.setStock(medicine.getStock() + additionalStock);
        medicine.setPrice(newPrice);

        return medicineRepository.save(medicine);
    }


    //verify stock during the sale, by id
    public Medicine verifyMedicineStock(Long id, int quantity) { //O parametro quantity representa a quantidade solicitada numa venda. Nao vem de nenhuma classe
        Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new RuntimeException("Medicine not found"));
        if (medicine.getStock() < quantity) {
            throw new RuntimeException("Stock excedes quantity. Medicine:" + medicine.getName());
        }
        return medicine;
    }


    //update stock after sale
    public void updateStockAfterSale(Long id, int quantity) {
        Medicine medicine = verifyMedicineStock(id, quantity);
        medicine.setStock(medicine.getStock() - quantity);
        medicineRepository.save(medicine);
    }

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Medicine getMedicineByName(String name) {
        return medicineRepository.findByName(name).orElseThrow(() -> new RuntimeException("Medicine not found by the name:" + name));
    }
    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));
    }

    public void deleteMedicine(Long id){
        medicineRepository.deleteById(id);
    }
}
