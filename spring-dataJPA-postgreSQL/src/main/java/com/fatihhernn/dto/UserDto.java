package com.fatihhernn.dto;

import com.fatihhernn.entity.Address;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class UserDto {
    private Long id;

    @NotNull
    private String name;

    private String surname;

    private List<String> addresses;
}
