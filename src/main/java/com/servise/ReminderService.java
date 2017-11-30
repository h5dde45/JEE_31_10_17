package com.servise;

import com.entity.Remind;

import java.util.List;

public interface ReminderService {


    List<Remind> getAll();

    Remind getById(long remindId);

    Remind save(Remind remind);

    void remove(long remindId);
}
