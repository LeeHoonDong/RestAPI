package kr.co.studyrestapi.restfulwebservice.Domain;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data //getter setter toString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    @Size(min=2,message="Name은 두글자 이상을 입력해주세요.")
    private String name;
    @Past //과거 데이터는 올수 없다
    private Date joinDate;
}
