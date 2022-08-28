package guru.springframework.sfgpetclinic.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by jt on 7/13/18.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owners")
public class Owner extends Person {

    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Pet> pets = new HashSet<>();

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Owner owner = (Owner) o;
        return getId() != null && Objects.equals(getId(), owner.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Owner{" +
                "firstname='" + this.getFirstName() + '\'' +
                "lastname='" + this.getLastName() + '\'' +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
