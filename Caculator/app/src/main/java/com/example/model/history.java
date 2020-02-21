package com.example.model;

import java.util.Stack;

public class history {
    private Stack<Double> history=new Stack<>();
    public void add(Double d){
        history.push(d);
    }
    public Double get(){
        if (history.empty()) return Double.MAX_VALUE;
        return history.peek();
    }
    public void pop(){
        history.pop();
    }
}
