package backend.academy.lab4web.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "point")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double x;
    private double y;
    private double r;
    @Column(name = "got_it")
    private boolean gotIt;

    public Point(double x, double y, double r, boolean gotIt) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.gotIt = gotIt;
    }
}
