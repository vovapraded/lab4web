package backend.academy.lab4web.util;

import backend.academy.lab4web.exception.ValidationException;

public class Validator {
    public void validate( double x, double y, double r){
        StringBuilder sb = new StringBuilder();

        if (x<-3 || x>5) {
            sb.append("Невалидное значение x\n");
        }
        if (y>5 || y<-5 ){
            sb.append("Невалидное значение y\n");
        }
        if (r<1 || r>5 ){
            sb.append("Невалидное значение R\n");
        }
        if (!sb.isEmpty()){
            throw new ValidationException(sb.toString());
        }
    }
}
