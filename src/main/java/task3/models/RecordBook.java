package task3.models;

import task3.controllers.InputNotebookRecord;
import task3.myExceptions.NotUniqueLoginException;

import java.util.ArrayList;
import java.util.List;

public class RecordBook {
    private List<PhoneRecord> records = new ArrayList<>();

    public void addRecord(InputNotebookRecord inr) throws NotUniqueLoginException {
        for (PhoneRecord rec: records) {
            if (rec.getNickname().equals(inr.getNickname())) {
                throw new NotUniqueLoginException("This nickname is already busy", inr);
            }
        }
        records.add(new PhoneRecord(inr));
    }

    public List<PhoneRecord> getRecords() {
        return records;
    }
}
