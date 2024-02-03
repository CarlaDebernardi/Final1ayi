package com.example.demo.exception;

public class EmpleadoException extends RuntimeException{
    public EmpleadoException (){super ("El empleado ingresado ya se encuentra en la base de datos");}
}
