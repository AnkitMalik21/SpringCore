package com.hcl.collection;

import java.util.List;

public class Student {
    private List<String> subjects;
    //setter like di
    
    public void setSubjects(List<String>subjects) {
    	this.subjects=subjects;
    }
    
    public void displaySubject() {
    	System.out.println("Subject: " + subjects);
    }
}
