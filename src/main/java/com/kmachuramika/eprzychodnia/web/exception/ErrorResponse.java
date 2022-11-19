package com.kmachuramika.eprzychodnia.web.exception;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ErrorResponse {

    private static final String FORBIDDEN = "FORBIDDEN";
    private static final String BAD_REQUEST = "BAD_REQUEST";

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime timestamp;
    private int status;
    private Error error;

    public ErrorResponse(LocalDateTime timestamp, int status, String key, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = new Error(key, message, path);
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Error {
        private String key;
        private String message;
        private String path;
    }

    public static ErrorResponse accessDenied(HttpServletRequest req, String msg) {
        String path = req.getRequestURI();
        return new ErrorResponse(LocalDateTime.now(),
                403, FORBIDDEN, msg, path);
    }

    public static ErrorResponse accessDenied(HttpServletRequest req) {
        String path = req.getRequestURI();
        return new ErrorResponse(LocalDateTime.now(),
                403, FORBIDDEN, "Dostęp zabroniony", path);
    }

    public static ErrorResponse accessDeniedInvalidToken(HttpServletRequest req) {
        String path = req.getRequestURI();
        return new ErrorResponse(LocalDateTime.now(),
                403, FORBIDDEN, "Niepoprawny token.", path);
    }

    public static ErrorResponse accessDeniedInvalidAuthentication(HttpServletRequest req) {
        String path = req.getRequestURI();
        return new ErrorResponse(LocalDateTime.now(),
                403, FORBIDDEN, "Niepoprawne dane autentykacji.", path);
    }

    public static ErrorResponse accessDeniedAuthCredentialsNotFound(HttpServletRequest req) {
        String path = req.getRequestURI();
        return new ErrorResponse(LocalDateTime.now(),
                403, FORBIDDEN, "Brak header: Authorization: Bearer <token>.", path);
    }

    public static ErrorResponse badRequestMediaTypeNotSupported(HttpServletRequest req) {
        String path = req.getRequestURI();
        return new ErrorResponse(LocalDateTime.now(),
                400, BAD_REQUEST, "Brak header: Content-Type: application/json", path);
    }

    public static ErrorResponse badRequestRequiredBody(HttpServletRequest req) {
        String path = req.getRequestURI();
        return new ErrorResponse(LocalDateTime.now(),
                400, BAD_REQUEST, "Wymagene podanie body requestu.", path);
    }

    public static ErrorResponse badRequestMessageNotReadable(HttpServletRequest req) {
        String path = req.getRequestURI();
        return new ErrorResponse(LocalDateTime.now(),
                400, BAD_REQUEST, "Niepoprawny format JSON.", path);
    }
}
