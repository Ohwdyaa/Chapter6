package com.example.Chapter6.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Merchant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long merchantCode;

    private String merchantName;
    private String merchantLocation;
    private boolean open;
}