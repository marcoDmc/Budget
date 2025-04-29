package com.budget;

import java.io.IOException;

import com.budget.controllers.Signin;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Signin.getUser();
        System.out.println("server running on port 5000");
    }
}
