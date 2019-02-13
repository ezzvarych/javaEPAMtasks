package task3.models;

import java.util.ArrayList;
import java.util.List;

public class RecordBook {
    private List<PhoneRecord> records = new ArrayList<>();

    public void addRecord(PhoneRecord pr) {
        records.add(pr);
    }

    public List<PhoneRecord> getRecords() {
        return records;
    }
}
