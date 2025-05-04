package Model;

import java.util.*;

public class UserHistoryManager {
    public static class HistoryEntry {
        public String username;
        public String type; // "warmup" or "workout"
        public String description;
        public String date;

        public HistoryEntry(String username, String type, String description, String date) {
            this.username = username;
            this.type = type;
            this.description = description;
            this.date = date;
        }

        public String toString() {
            return "[" + date + "] " + type.toUpperCase() + ": " + description;
        }
    }

    private static final List<HistoryEntry> historyLog = new ArrayList<>();

    public static void log(String username, String type, String description, String date) {
        historyLog.add(new HistoryEntry(username, type, description, date));
    }

    public static List<HistoryEntry> getHistoryFor(String username) {
        List<HistoryEntry> result = new ArrayList<>();
        for (HistoryEntry e : historyLog) {
            if (e.username.equals(username)) result.add(e);
        }
        return result;
    }
}
