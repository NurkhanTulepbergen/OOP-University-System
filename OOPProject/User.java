package OOPProject;

import java.util.Vector;

public abstract class User {
	private String login;
	private String password;
	public Language language;
	User() {
		
	}
	User(String login, String password, Language language) {
		this.login = login;
		this.password = password;
		this.language = language;
	}
	public boolean checkStatus(String log, String pas) {
		for(Student s: DataBase.students) {
			if(s.getLogin().equals(log) && s.getPassword().equals(pas)) {
				return true;
			}
		}
		for(Teacher t: DataBase.teachers) {
			if(t.getLogin().equals(log) && t.getPassword().equals(pas)) {
				return true;
			}
		}
		return false;
	}/*
	public void viewNews() {
		for(News n: News.news)
	}*/
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void changePassword(String password) {
		this.password = password;
	}
	public Language getLanguage() {
		return language;
	}
	public void changeLanguage(Language language) {
		this.language = language;
	}
	public String toString() {
		return "Login: " + login + ", Password: " + password + ", Language: " + language;
	}
}
