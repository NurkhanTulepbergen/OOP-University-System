package projects;

public class Dean {
    private String deanName;

    public Dean(String deanName) {
        this.deanName = deanName;
    }

    public String getDeanName() {
        return deanName;
    }

    // Method to receive a complaint from a teacher
    public void receiveComplaint(Teacher teacher, Student student, Complaint complaint) {
        switch (complaint.getUrgencyLevel()) {
            case LOW:
                System.out.println("Dean received a LOW urgency complaint from " + teacher.getTeacherName() +
                        " regarding student " + student.getStudentName() + ": " + complaint.getComplaintText());
                break;
            case MEDIUM:
                System.out.println("Dean received a MEDIUM urgency complaint from " + teacher.getTeacherName() +
                        " regarding student " + student.getStudentName() + ": " + complaint.getComplaintText());
                break;
            case HIGH:
                System.out.println("Dean received a HIGH urgency complaint from " + teacher.getTeacherName() +
                        " regarding student " + student.getStudentName() + ": " + complaint.getComplaintText());
                break;
            default:
                System.out.println("Invalid urgency level");
        }
    }
}
