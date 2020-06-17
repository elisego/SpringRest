package wcs.springRest.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String title;

    private String auhor;

    private String description;

    public Book(){

    }

    public Book(Long id, String title, String auhor, String description) {
        this.id = id;
        this.title = title;
        this.auhor = auhor;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuhor() {
        return auhor;
    }

    public void setAuhor(String auhor) {
        this.auhor = auhor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
