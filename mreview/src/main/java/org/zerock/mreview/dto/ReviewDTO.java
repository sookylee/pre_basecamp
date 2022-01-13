package org.zerock.mreview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    //review num
    private Long reviewnum;
    //movie mno
    private Long mno;

    //memeber id
    private Long mid;
    //memeber nickname
    private String nickname;
    //member email
    private String email;

    private int grade;

    private String text;

    private LocalDateTime regDate, modDate;

}
