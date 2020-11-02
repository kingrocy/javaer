package metaspace_oom;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PortraitLabelInfo {

    private Integer id;

    private String labelName;

    private Integer labelDomain;

    private Integer labelBiz;

    private Integer labelType;

    private Integer labelTypeFirst;

    private Integer labelTypeSecond;
    
}