package pro.sky.coursework2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "The Amount of questions requested is wrong")
public class WrongQuestionAmountRequested extends IllegalArgumentException {
    public WrongQuestionAmountRequested() {
        super();
    }
}
