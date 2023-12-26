public class Mark implements Serializable {
	public int grade;
	public Course course;
	public int firstAttest;
	public int secondAttest;
	public int session;
	public Period semester;
	
	public Mark() {};
	
	public Mark(int grade, Course course) {
		this.grade = grade;
		this.course = course;
	}
	
	public Mark(int grade, Course course, int firstAttest, int secondAttest, int session, Period semester) {
		this.grade = grade;
		this.course = course;
		this.firstAttest = firstAttest;
		this.secondAttest = secondAttest;
		this.session = session;
		this.semester = semester;
		
	}
	
	
	public Course getCourse() {
		return course;
	}
	
	public int getGrade() {
		return firstAttest + secondAttest + session;
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
            return "F";
        }
    }
    
    public static double convertGradeGPA(int grade) {
        if (grade >= 95 && grade <= 100) {
            return 4.0;
        } else if (grade >= 90 && grade < 95) {
            return 3.67;
        } else if (grade >= 85 && grade < 90) {
            return 3.33;
        } else if (grade >= 80 && grade < 85) {
            return 3.0;
        } else if (grade >= 75 && grade < 80) {
            return 2.67;
        }else if (grade >= 70 && grade < 75) {
            return 2.33;
        } else if (grade >= 65 && grade < 70) {
            return 2.0;
        } else if (grade >= 60 && grade < 65) {
            return 1.67;
        } else if (grade >= 55 && grade < 60) {
            return 1.33;
        } else if(grade >= 50 && grade < 55) {
        	return 1.0;
        }
          else {
            return 0;
        }
    }

	public int getMark() {
		return grade;
	}
	
}
