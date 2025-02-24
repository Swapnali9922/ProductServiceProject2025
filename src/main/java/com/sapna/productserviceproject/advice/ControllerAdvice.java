package com.sapna.productserviceproject.advice;

import com.sapna.productserviceproject.Exception.ProductNotFoundException;
import com.sapna.productserviceproject.dtos.Errordto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Errordto> handleerrorexception(){
        Errordto errordto=new Errordto();
         errordto.setErroMsg("bad request");
         errordto.setErrorCode("400");
return ResponseEntity.badRequest().body(errordto);

    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Errordto> ProductNotFoundException(){
        Errordto errordto=new Errordto();
        errordto.setErroMsg("Product Not Found");
        errordto.setErrorCode("400");
        return ResponseEntity.badRequest().body(errordto);

    }




}
