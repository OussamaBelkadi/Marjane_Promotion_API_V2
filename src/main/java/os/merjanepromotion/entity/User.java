package os.merjanepromotion.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public abstract class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long id;
    private String version;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATED_AT")
    protected LocalDateTime createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "UPDATED_AT")
    protected LocalDateTime updatedAt;
    @NotNull
    protected String nom;
    @NotNull
    protected String prenom;
    @Email
    @NotNull
    @Column(unique=true)
    protected String email;
    @NotNull
    protected String password;
    @NotNull
    protected String username;
    @Size(min=0,max=10)
    @Pattern(regexp="(^$|[0-9]{10})")
    protected String telephone;

}
