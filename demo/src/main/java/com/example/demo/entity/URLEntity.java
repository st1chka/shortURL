package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "urlentity")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class URLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "long_url")
    private String longURL;

    @Column(name = "short_url")
    private String shortURL;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

}
