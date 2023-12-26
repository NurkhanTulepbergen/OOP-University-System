package OOPProject;

public class Lesson {
	public TypeOfLesson typeLesson;
	public Teacher teacher;
	public Course course;
	
	public Lesson() {}
	
	public Lesson(TypeOfLesson typeLesson, Teacher teacher, Course course) {
		this.typeLesson = typeLesson;
		this.teacher = teacher;
		this.course = course;
	}
	
    public TypeOfLesson getLessonType() {
        return typeLesson;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Course getCourse() {
        return course;
    }
}
