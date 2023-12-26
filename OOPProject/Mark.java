package OOPProject;

public class Mark {
	public int grade;
	public Course course;//Course course nege koldandyk? getMark ta koldanbasak
	public int firstAttest;
	public int secondAttest;
	public int total;
	
	public int getMark() {
		return grade;
	}
	
    public static String convertGrade(int grade) {
        if (grade >= 95 && grade <= 100) {
            return "A";
        } else if (grade >= 90 && grade < 95) {
            return "A-";
        } else if (grade >= 85 && grade < 90) {
            return "B+";
        } else if (grade >= 80 && grade < 85) {
            return "B";
        } else if (grade >= 75 && grade < 80) {
            return "B-";
        }else if (grade >= 70 && grade < 75) {
            return "C+";
        } else if (grade >= 65 && grade < 70) {
            return "C";
        } else if (grade >= 60 && grade < 65) {
            return "C-";
        } else if (grade >= 55 && grade < 60) {
            return "D+";
        } else if(grade >= 50 && grade < 55) {
        	return "D";
        }
          else {
            return "Fail";
        }
    }
	
}
