package com.enesbayram.gallerist.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<E> {

    private Integer status;

    private Exception<E> exception;

}
