package com.epam.mjc.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            Map<String, String> keyValue = new HashMap<>();
            while (br.ready()) {
                String[] split = br.readLine().split(":");
                keyValue.put(split[0], split[1].strip());
            }

            br.close();

            return new Profile(
                    keyValue.get("Name"),
                    Integer.parseInt(keyValue.get("Age")),
                    keyValue.get("Email"),
                    Long.parseLong(keyValue.get("Phone")));

        } catch (IOException ignore) {
        }
        return new Profile();
    }
}
