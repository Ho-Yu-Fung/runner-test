package com.example.runnertest.other;

import com.example.runnertest.utils.Md5Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) throws ParseException {
        System.out.println(Md5Utils.getRamdomSalt());
    }
}
