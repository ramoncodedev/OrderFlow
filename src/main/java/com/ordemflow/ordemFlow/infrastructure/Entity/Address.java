package com.ordemflow.ordemFlow.infrastructure.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    @Column(name = "street",length = 250, nullable = false)
   private String street;

    @Column(name = "number", length = 100, nullable = false)
   private String number;

    @Column(name = "complement", length = 100)
   private String complement;

    @Column(name = "city", length = 50, nullable = false)
   private String city;

    @Column(name = "state", length = 2 ,nullable = false)
   private String state;

    @Column(name = "cep",length = 150, nullable = false)
   private String cep;

   @OneToOne
   @JoinColumn(name = "Restaurant_id")
   private Restaurant restaurant;
}
