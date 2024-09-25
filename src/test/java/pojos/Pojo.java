package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pojo {

    /*
    {
    "phone": "01000000004",
    "address": "Houston, Texas"
}
     */

    private String phone;
    private String address;
}
