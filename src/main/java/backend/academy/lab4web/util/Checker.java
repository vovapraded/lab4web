package backend.academy.lab4web.util;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Checker {
    @GetMapping("/check")
    public boolean check(@RequestParam  double x,@RequestParam double y,@RequestParam double r) {
        if (r <= 0) {
            return false;
        }
        if (y==0 && x==0){
            return true;
        }

        // Проверка для x < 0
        if (x < 0) {
            if (y < 0) {
                return  x*x+y*y<=r*r/4;

            } else {
                return y<=x/2+r/2;
            }
        }
        else {
            // 1-й квадрант (x >= 0 и y > 0)
            if (y < 0) {
                return false;
            }
            // 4-й квадрант (x >= 0 и y < 0) - треугольник с гипотенузой на линии y = x/2 - r/2
            else  {
                  return       x<=r && y<=r;
            }
        }

        // Если точка находится на осях или не попадает в область
    }
}
