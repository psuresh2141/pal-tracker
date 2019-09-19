package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap<Long,TimeEntry> timeEntries = new HashMap<>();
    private long currentid = 1L;


    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        Long id = currentid++;
        TimeEntry entry = new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntries.put(id,entry);
        return entry;
    }

    @Override
    public TimeEntry find(Long timeEntryID) {
        return timeEntries.get(timeEntryID);
    }


    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(timeEntries.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        if(find(id)==null)
            return null;
        TimeEntry entry = timeEntries.get(id);
        TimeEntry newEntry = new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntries.replace(id,newEntry);
        return newEntry;
    }

    @Override
    public void delete(Long id) {
        TimeEntry entry = timeEntries.get(id);
        timeEntries.remove(id);

    }


}
