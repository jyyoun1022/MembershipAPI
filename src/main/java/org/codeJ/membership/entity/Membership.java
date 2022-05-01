package org.codeJ.membership.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MembershipType membershipType;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer point;

    @Column(nullable = false)
    private String userId;

    @CreationTimestamp
    @Column(nullable = false,length = 20, updatable = false)
    private LocalDateTime createdAt;

    @Column(length = 20)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
