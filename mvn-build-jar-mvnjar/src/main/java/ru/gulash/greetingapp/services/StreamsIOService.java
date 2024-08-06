package ru.gulash.greetingapp.services;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

@Component
public class StreamsIOService implements IOService {

    private final PrintStream ps;
    private final Scanner sc;

    public StreamsIOService() {
        this.ps = System.out;
        this.sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }

    @Override
    public void outputString(String s) {
        ps.println(s);
    }

    @Override
    public void outputAsString(Object o) {
        ps.println(o);
    }

}
