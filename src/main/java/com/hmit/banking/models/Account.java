package com.hmit.banking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acount_id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(name = "account_number", nullable = false, unique = true, columnDefinition = "VARCHAR(255)")
    private String accountNumber;

    private String name;

    private String CID;

    private String phone;

    private String password;

    private Long balance;

    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;

    @JsonIgnore
    @OneToMany(mappedBy = "accountSend", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<History> historiesSend;

    @JsonIgnore
    @OneToOne(mappedBy = "accountReceive", cascade = CascadeType.ALL, orphanRemoval = true)
    private History historiesReceive;
}
