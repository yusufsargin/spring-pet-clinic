package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.common.model.BaseEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Created by jt on 7/13/18.
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "types")
public class PetType extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        PetType petType = (PetType) o;
        return getId() != null && Objects.equals(getId(), petType.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
