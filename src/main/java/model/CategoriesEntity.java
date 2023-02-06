package model;

import javax.persistence.*;

@Entity
@Table(name = "categories_table")
public class CategoriesEntity {

    @Id
    @Column(name = "category_name")
    private String category_name;

    @ManyToOne
    @JoinColumn(name = "id_lineup")
    private LineupEntity lineup;

    CategoriesEntity(){}
    CategoriesEntity(LineupEntity lineup, String name) {
        this.lineup = lineup;
        this.category_name = name;
    }

    @Override
    public String toString() {
        return category_name;
    }

    public LineupEntity getLineup() {
        return lineup;
    }
}