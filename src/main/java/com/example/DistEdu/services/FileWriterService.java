package com.example.DistEdu.services;


import com.example.DistEdu.dto.UserDto;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service("fileWriterService")
public class FileWriterService {


    public void writeCredentials(UserDto userDto){
        String username = userDto.getUsername();
        String password = userDto.getPassword();


        try{
            File file = new File("LOGS/credentials.txt");
            FileWriter fileWriter = new FileWriter(file, true);

            fileWriter
            .append("\n")
                    .append("Username: ")
                            .append(username)
                                    .append("\n")
                                            .append("Password: ")
                                                    .append(password)
                                                        .append("\n");


            fileWriter.close();

        } catch (IOException e){
            System.out.println("Error with IO stream occurred");
        }
    }

}
