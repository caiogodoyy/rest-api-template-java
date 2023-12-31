package com.caio.alura.api.model.meeting;

import java.time.LocalDateTime;

public record MeetingRegisterReturnData(Long id, Long teacherId, Long studentId, LocalDateTime dateTime) {

    public MeetingRegisterReturnData(Meeting meeting) {
        this(meeting.getId(), meeting.getTeacher().getId(), meeting.getStudent().getId(), meeting.getDateTime());
    }
    
}
