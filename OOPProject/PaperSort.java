package OOPProject;

import java.util.Vector;

public class PaperSort {
	public static void SortPapers(Vector<ResearchPaper> vector) {
		// TODO Auto-generated method stub
		int n = vector.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vector.get(j).getTitle().compareTo(vector.get(j + 1).getTitle()) > 0) {
                    ResearchPaper temp = vector.get(j);
                    vector.set(j, vector.get(j + 1));
                    vector.set(j + 1, temp);
                }
            }
        }
	}
	public static void SortProjects(Vector<ResearchProject> vector) {
		// TODO Auto-generated method stub
		int n = vector.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vector.get(j).getTopic().compareTo(vector.get(j + 1).getTopic()) > 0) {
                    ResearchProject temp = vector.get(j);
                    vector.set(j, vector.get(j + 1));
                    vector.set(j + 1, temp);
                }
            }
        }
	}
}
