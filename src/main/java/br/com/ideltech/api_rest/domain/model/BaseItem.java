package br.com.ideltech.api_rest.domain.model;

import jakarta.persistence.*;
import java.util.Objects;

@MappedSuperclass
public  abstract class BaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String icon;
    private String description;

    // Getters and setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + this.getId() +
                ", icon='" + this.getIcon() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return Objects.equals(this.getId(), news.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

}
