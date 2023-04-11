package com.example.demo.domain.modle.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Collection {
    private Long id;
    private Long userId;
    private Long courseId;
    private Integer isCollection;
}
