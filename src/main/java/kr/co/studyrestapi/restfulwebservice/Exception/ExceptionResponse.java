package kr.co.studyrestapi.restfulwebservice.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private Date occur_time;
    private String exception_message;
    private String exception_detail;
}

