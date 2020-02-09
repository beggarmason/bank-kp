package edu.tusur.kp.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MappingUtility {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <T> void map(T target, Object source) {
        modelMapper.map(source, target);
    }

}
