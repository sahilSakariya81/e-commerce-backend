package ecommerce_backend.DTO;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class ResponseDTO {
    private String msg;
    private HttpStatus status;
    private Map<String, String> errors;

    public ResponseDTO(String msg, HttpStatus status) {
        this.msg = msg;
        this.status = status;
    }

    public ResponseDTO(String msg, HttpStatus status, Map<String, String> errors) {
        this.msg = msg;
        this.status = status;
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
