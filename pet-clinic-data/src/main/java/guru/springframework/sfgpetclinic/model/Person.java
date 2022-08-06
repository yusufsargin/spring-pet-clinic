package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by jt on 7/13/18.
 */
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

}
