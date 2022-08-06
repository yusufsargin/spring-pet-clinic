package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by jt on 7/29/18.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "specialities")
public class Speciality extends BaseEntity {

    private String description;
}
