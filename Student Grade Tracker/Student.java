class Student {
    private String name;
    private int register_no;
    private String dob;
    private int[] marks;

    Student(String name, int register_no, String dob, int[] marks) {
        this.name = name;
        this.register_no = register_no;
        this.dob = dob;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return register_no;
    }

    public String getDob() {
        return dob;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(int rollno) {
        this.register_no = rollno;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}