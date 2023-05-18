package com.hmit.banking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import jakarta.persistence.FetchType;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.type.SqlTypes;
import org.springframework.context.annotation.Lazy;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(name = "bank_name", nullable = false)
    private String name;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "bank", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Account> accounts;

}
