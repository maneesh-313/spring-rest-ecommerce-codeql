package net.vatri.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_groups")
public class ProductGroup {

    private Integer id;
    private String groupName;
    private String price;
    @Temporal(TemporalType.TIMESTAMP)
    private String created;//Todo - Date type...

    private List<GroupVariant> groupVariants;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    public List<GroupVariant> getGroupVariants() {
        return groupVariants;
    }

    public void setGroupVariants(List<GroupVariant> groupVariants) {
        this.groupVariants = groupVariants;
    }

    public String toString() {
        return getGroupName();
    }
}