package backend.academy.lab4web.service;

import backend.academy.lab4web.util.Checker;
import backend.academy.lab4web.util.Validator;
import backend.academy.lab4web.dto.Point;
import backend.academy.lab4web.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {
    private final PointRepository pointRepository;
    private final Validator validator = new Validator();
    private final Checker checker = new Checker();

    @Autowired
    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public List<Point> findAll() {
        return pointRepository.findAll();  // If using JpaRepository, `findAll()` is available by default
    }

    public Point create(double x, double y, double r) {
        validator.validate(x,y,r);
        var res = checker.check(x,y,r);
        return pointRepository.save(new Point(x,y,r,res));
    }


}