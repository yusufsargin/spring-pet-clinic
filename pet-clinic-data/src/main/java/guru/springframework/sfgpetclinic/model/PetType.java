package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by jt on 7/13/18.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "types")
public class PetType extends BaseEntity {

    @Column(name = "name")
    private String name;
}
