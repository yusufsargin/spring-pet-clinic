package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by jt on 7/29/18.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
