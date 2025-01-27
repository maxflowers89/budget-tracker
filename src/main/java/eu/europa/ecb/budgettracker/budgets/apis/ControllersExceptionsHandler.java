package eu.europa.ecb.budgettracker.budgets.apis;

import eu.europa.ecb.budgettracker.budgets.dtos.ErrorDetails;
import eu.europa.ecb.budgettracker.budgets.repositories.exceptions.DocumentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllersExceptionsHandler {

    @ExceptionHandler(DocumentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorDetails documentNotFoundException(
            DocumentNotFoundException exception,
            WebRequest request) {
        return new ErrorDetails(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                request.getDescription(false));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorDetails methodArgumentNotValidException(
            MethodArgumentNotValidException exception,
            WebRequest request) {
        return new ErrorDetails(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                request.getDescription(false));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDetails globalException(
            Exception exception,
            WebRequest request) {
        return new ErrorDetails(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(),
                request.getDescription(false));
    }
}
