package com.kodlamaio.bootccampproject.core.utilities.exceptions;

//Applicant ayni tc ile kaydedilmesin . Inst ve employee tc kontrolu

public class BusinessException  extends  RuntimeException{

    public BusinessException (String message){

        super(message);
    }
}
