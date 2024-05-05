package com.turkcell.rentacar.core.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;


@Entity
@Table(name="roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role extends BaseEntity implements GrantedAuthority{
    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "authorities")
    private Set<Customer> customers;

    @Override
    public String getAuthority() {
        return this.name.toLowerCase();
    }
}

