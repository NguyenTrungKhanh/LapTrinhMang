/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Santa
 */
public class Answer {
    final long serialVersionUID=2L;
    Student student;
    Object[] answer;
    boolean[] isRight;
    boolean alreadyRegistration;

    public Answer() {
        
    }
    public Answer(Student student, Object[] answer, boolean[] isRight, boolean alreadyRegistration) {
        this.student = student;
        this.answer = answer;
        this.isRight = isRight;
        this.alreadyRegistration = alreadyRegistration;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Object[] getAnswer() {
        return answer;
    }

    public void setAnswer(Object[] answer) {
        this.answer = answer;
    }

    public boolean[] getIsRight() {
        return isRight;
    }

    public void setIsRight(boolean[] isRight) {
        this.isRight = isRight;
    }

    public boolean isAlreadyRegistration() {
        return alreadyRegistration;
    }

    public void setAlreadyRegistration(boolean alreadyRegistration) {
        this.alreadyRegistration = alreadyRegistration;
    }
    
}
