package archorganizer.model.project;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String sector;

    @OneToMany(mappedBy = "stage", cascade = {CascadeType.ALL})
    private Set<Material> materials = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Set<Material> getMaterials() {
        return materials;
    }

    public void addMaterial(Material material) {
        this.materials.add(material);
    }
}
