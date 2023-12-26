package projects;

import java.util.Date;

public class Complaint {
    private String complaintText;
    private Date timestamp;
    private UrgencyLevel urgencyLevel;

    public Complaint(String complaintText, UrgencyLevel urgencyLevel) {
        this.complaintText = complaintText;
        this.timestamp = new Date();
        this.urgencyLevel = urgencyLevel;
    }

    public String getComplaintText() {
        return complaintText;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public UrgencyLevel getUrgencyLevel() {
        return urgencyLevel;
    }
}
