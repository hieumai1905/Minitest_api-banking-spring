package com.hmit.banking.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "historeis")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(name = "time_stamps", nullable = false, columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private LocalDate timeStamps;

    private Long amount;

    @ManyToOne
    @JoinColumn(name = "account_send_id", nullable = false)
    private Account accountSend;

    @OneToOne
    @JoinColumn(name = "account_receive_id", nullable = false)
    private Account accountReceive;

    @PrePersist
    public void prePersist() {
        this.timeStamps = LocalDate.now();
        amount = 0L;

    }
}
