package backend.academy.lab4web.controller;



import backend.academy.lab4web.exception.ValidationException;
import backend.academy.lab4web.dto.Point;
import backend.academy.lab4web.service.PointService;
import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@RestController
@RequestMapping("/api")  // Все URL этого контроллера будут начинаться с /api
public class PointController implements Serializable {
    private final PointService pointService;
    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping("/points")
private List<Point> points() {
    return pointService.findAll();
}

    @PostMapping("/point")
    private Point save(@RequestParam double x, @RequestParam double y, @RequestParam double r) {
        return pointService.create(x, y, r);
    }
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
