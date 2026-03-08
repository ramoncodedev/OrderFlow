package com.ordemflow.ordemFlow.infrastructure.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;



@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurante")
public class Restaurant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "name",length = 100,nullable = false)
    private String name;

    @Column(name = "description",length = 260 ,nullable = false)
    private String description;

    @Column(name = "phone", length = 15,nullable = false)
    private String phone;

    @Column(name = "email",length = 50,nullable = false)
    private String email;

    @Column(name = "imagem_url")
    private String imagemUrl;

    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Address address;

    @Column(name = "active", nullable = false, updatable = false)
    private boolean active;

    @CreationTimestamp
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;
}
