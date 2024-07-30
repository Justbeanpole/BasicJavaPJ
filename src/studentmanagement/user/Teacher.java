package studentmanagement.user;

import studentmanagement.constants.Subject;

public class Teacher extends User {
    private Subject subject;
    public Teacher(String id, String name, Subject subject) {
        this.id = id;
        this.password = id;
        this.name = name;
        this.subject = subject;
    }
    @Override
    public String  getInfo(){
        return String.format("ID: %s | Password: %s | Name: %s | Subject: %s", id, password, name, subject.name());
    }

    public void setSubject(String subjectName) {
        this.subject = subject.valueOf(subjectName);
    }

    public String getSubject() {
        return subject.name();
    }
}
