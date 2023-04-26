package hh.healthhive.Model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReplyResponse {
    private Reply reply;
    private String userName;
}
