package com.example.Chapter6.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTime;

    private String destinationAddress;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private boolean completed;

    @OneToMany(mappedBy = "order")
    private List<DetailOrder> orderDetails;

    // getters and setters
}