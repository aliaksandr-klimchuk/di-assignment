package alex.klimchuk.spring5.sfgdi.handlers;

import alex.klimchuk.spring5.sfgdi.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFoundException(NotFoundException exception) {
        log.error("Handling not found exception!", exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.setViewName("errorPage");
        return modelAndView;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormatException(NumberFormatException exception) {
        log.error("Handling number format exception!", exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception);
        modelAndView.setViewName("errorPage");
        return modelAndView;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex,
                                                               final HttpHeaders headers, final WebRequest request) {
        final String responseBody = "Http message not readable exception";
        return handleExceptionInternal(ex, responseBody, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
                                                               final HttpHeaders headers, final WebRequest request) {
        final String responseBody = "Method argument not valid exception";
        return handleExceptionInternal(ex, responseBody, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleBadRequest(final ConstraintViolationException ex,
                                                   final HttpHeaders headers, final WebRequest request) {
        final String responseBody = "Constraint violation exception";
        return handleExceptionInternal(ex, responseBody, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleBadRequest(final DataIntegrityViolationException ex,
                                                   final HttpHeaders headers, final WebRequest request) {
        final String responseBody = "Data integrity violation exception";
        return handleExceptionInternal(ex, responseBody, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<Object> handleMethodNotAllowedException(final MethodNotAllowedException ex,
                                                                  final HttpHeaders headers, final WebRequest request) {
        final String responseBody = "Method not allowed Exception";
        return handleExceptionInternal(ex, responseBody, headers, HttpStatus.METHOD_NOT_ALLOWED, request);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> handleSQLException(final SQLException ex,
                                                     final HttpHeaders headers, final HttpServletRequest httpRequest) {
        log.error("SQLException Occurred :: URL=" + httpRequest.getRequestURL());
        WebRequest request = (WebRequest) httpRequest;
        final String responseBody = "Problems with DataBase";
        return handleExceptionInternal(ex, responseBody, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Object> handleConflict(final RuntimeException ex,
                                                 final HttpHeaders headers, final WebRequest request) {
        log.warn("409 Status Code: ", ex);
        final String responseBody = "Data access exception";
        return handleExceptionInternal(ex, responseBody, headers, HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<Object> handleInternalServerError(final Exception ex,
                                                            final HttpHeaders headers, final WebRequest request) {
        log.error("500 Status Code: Internal server error", ex);
        final String responseBody = "Internal server error";
        return handleExceptionInternal(ex, responseBody, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

}
