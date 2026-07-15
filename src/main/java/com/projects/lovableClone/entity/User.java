package com.projects.lovableClone.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults; // experimental features should be used depending on the company you are working for
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter // as getter and setter annotation is used so we don't need to create getter and setter separately
@FieldDefaults(level = AccessLevel.PRIVATE) //we can define different type of access level
// now this package doesn't need private access modifier, it will make the fields private automatically
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String email;
    String passwordHash;
    String name;
    String avatarUrl;

    // localDateTime or Instant
    @CreationTimestamp
    Instant createdAt;

    @UpdateTimestamp
    Instant updatedAt;

    Instant deletedAt;
}
