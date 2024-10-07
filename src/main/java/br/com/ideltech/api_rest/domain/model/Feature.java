package br.com.ideltech.api_rest.domain.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity(name = "tb_feature")
public class Feature extends BaseItem {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Feature() {
        super();
    }

    // Getters and setters...

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + this.getId() +
                ", icon='" + this.getIcon() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feature)) return false;
        Feature feature = (Feature) o;
        return Objects.equals(this.getId(), feature.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
