package com.kason.onlinebiz.result;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse<T> {

    private String code;
    private String message;
    private T result;


    public ApiResponse(String code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public static <T> ApiResponse<T> success(T result) {
        return new ApiResponse("success", "success", result);
    }

}
