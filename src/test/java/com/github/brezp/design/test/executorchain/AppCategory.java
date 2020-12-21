package com.github.brezp.design.test.executorchain;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 品类实体
 *
 */
@Getter
@Setter
@Accessors(chain = true)
public class AppCategory  implements Serializable {

    private Integer id;
    private String name;
    private Integer level;
    private String pid;


    private String pidPath;
    private String path;
    private String industry;




}