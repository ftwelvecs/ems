package kz.f12.school.ems.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "regions")
public class Region {

    private static final String SEQUENCE_NAME = "regions_s";
    @Id
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    private String name;

  /*  @OneToMany(mappedBy = "region", fetch = FetchType.EAGER)
    private List<Department> departments;*/

    @Override
    public String toString() {
        return "Regions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
/* public Regions(String name){
        this.name = name;
    }*/


}
