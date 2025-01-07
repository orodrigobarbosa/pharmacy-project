package com.pharmacy_project.sale.domain;

import com.pharmacy_project.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idCustomer; //cfp
    private double amount;

    @ManyToOne
    private Medicine medicine;

    @ManyToOne
    private User attendant;
}
